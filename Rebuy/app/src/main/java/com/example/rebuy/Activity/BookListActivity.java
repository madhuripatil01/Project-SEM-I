package com.example.rebuy.Activity;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebuy.Adapter.BooksAdapter;
import com.example.rebuy.DataModels.ProductModel;
import com.example.rebuy.R;
import com.example.rebuy.Utility.RebuyDatabaseClient;

import java.util.ArrayList;
import java.util.List;

public class BookListActivity extends AppCompatActivity {
    RecyclerView rec_books;
    BooksAdapter booksAdapter;
    Context context;
    private List<ProductModel> BookList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rec_books_lay);
        rec_books = findViewById(R.id.rec_books);

        if(getIntent().getStringExtra("catogoryBook").equals("Book")) {
            String strcat = getIntent().getStringExtra("catogoryBook");
            BookList = RebuyDatabaseClient.getRebuyInstance(this).getRebuyDatabase()
                    .productDAO().SelectProdByCategory(strcat);


            booksAdapter = new BooksAdapter(BookList, this);
            rec_books.setLayoutManager(new LinearLayoutManager(this,
                    LinearLayoutManager.VERTICAL, false));
            rec_books.setAdapter(booksAdapter);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        MenuItem menuItem=menu.findItem(R.id.action_search);
        SearchView searchView= (SearchView) menuItem.getActionView();

        searchView.setQueryHint("Search Products");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                final List<ProductModel> PList=filter(BookList,newText);
                booksAdapter.setFilterList(PList);
                return true;
            }
        });
        return true;
    }
    private List<ProductModel> filter(List<ProductModel> BookList,String newText)
    {
        final  List<ProductModel> PList=new ArrayList<>();
        for (ProductModel searchproduct : BookList)
        {
            final String text=searchproduct.getProdName().toLowerCase();
            if (text.contains(newText))
            {

                PList.add(searchproduct);
            }
        }
        return PList;
    }
}