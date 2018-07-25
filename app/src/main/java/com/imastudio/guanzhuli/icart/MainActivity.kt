package com.imastudio.guanzhuli.icart

import android.content.Intent
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.SearchView
import android.view.MenuInflater
import android.view.View
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem

import com.imastudio.guanzhuli.icart.fragments.*



class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        val hView = navigationView.getHeaderView(0)


        navigationView.setNavigationItemSelectedListener(this)

        if (findViewById<View>(R.id.main_fragment_container) != null) {
            val homeFragment = HomeFragment()
            supportFragmentManager.beginTransaction().replace(R.id.main_fragment_container, homeFragment).commit()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_view_menu, menu)
        val searchViewItem = menu.findItem(R.id.action_search)
        val searchIcon = searchViewItem.icon // change 0 with 1,2 ...
        searchIcon.mutate()
        searchIcon.setColorFilter(resources.getColor(R.color.icons), PorterDuff.Mode.SRC_IN)
        val searchViewAndroidActionBar = MenuItemCompat.getActionView(searchViewItem) as SearchView
        searchViewAndroidActionBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchViewAndroidActionBar.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })

        val item = menu.findItem(R.id.action_cart)
        val cartIcon = item.icon
        cartIcon.setColorFilter(resources.getColor(R.color.icons), PorterDuff.Mode.SRC_IN)
        item.intent = Intent(this@MainActivity, CartActivity::class.java)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStack()
        }
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }

    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId
        val transaction = supportFragmentManager.beginTransaction()

        when (id) {
            R.id.nav_home -> {
                val homeFragment = HomeFragment()
                transaction.replace(R.id.main_fragment_container, homeFragment).commit()
            }
            R.id.nav_category -> {
                val categoryFragment = CategoryFragment()
                transaction.addToBackStack(CategoryFragment::class.java!!.getName())
                transaction.replace(R.id.main_fragment_container, categoryFragment)
                        .setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
                        .commit()
            }
            R.id.nav_profile -> {
                val profileFragment = ProfileFragment()
                transaction.addToBackStack(CategoryFragment::class.java!!.getName())
                transaction.replace(R.id.main_fragment_container, profileFragment)
                        .setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
                        .commit()
            }
            R.id.nav_wallet -> {
            }
            R.id.nav_order -> {
                val orderHistoryFragment = OrderHistoryFragment()
                transaction.addToBackStack(OrderHistoryFragment::class.java!!.getName())
                transaction.replace(R.id.main_fragment_container, orderHistoryFragment)
                        .setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
                        .commit()
            }
            R.id.nav_favorite -> {
            }
            R.id.nav_help -> {
                val helpFragment = HelpFragment()
                transaction.addToBackStack(OrderHistoryFragment::class.java!!.getName())
                transaction.replace(R.id.main_fragment_container, helpFragment)
                        .setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
                        .commit()
            }
            R.id.nav_rate -> {
            }
            R.id.nav_logout -> {
                startActivity(Intent(this@MainActivity, SignInActivity::class.java))
            }
            else -> {
            }
        }

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
