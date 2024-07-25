package com.pages.digital_Recalls.apt_DR;

import com.microsoft.playwright.Page;


public class ListViewPage {

    private final Page page;

    public ListViewPage(Page page){
        this.page =  page;
    }

    public final String applyfilterButton = "//button//span[text()='Apply']";

    public final String searchRecallsPageHeader = "//p[contains(text(),'Search Recalls')]";


    public String SearchRecallsPageHeader (){
        String context =  page.textContent(searchRecallsPageHeader);
        System.out.println("search Recalls Page Header - "+context );
        return context ;

    }

    public void clickApplyFilterButton (){
        page.click(applyfilterButton);
        System.out.println("Apply Button Clicked");
    }






}
