package com.hackyeon.converse.ui.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.*
import kotlinx.coroutines.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen() {

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(75.dp),
                backgroundColor = Color.LightGray
            ) {
                val pagerState = rememberPagerState()
                MainTopBar(pagerState)
                LaunchedEffect(Unit) {
                    while (true) {
                        yield()
                        delay(2000L)
                        pagerState.animateScrollToPage(
                            page = (pagerState.currentPage + 1) % pagerState.pageCount
                        )
                    }
                }
            }
        },
        bottomBar = {
            BottomAppBar {

            }
        }
    ) {

    }

}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun MainTopBar(
    state: PagerState
) {
    HorizontalPager(
        count = 3,
        state = state
    ) {
        val title = when(currentPage) {
            0 -> "NEW"
            1 -> "NEW"
            2 -> "PROMOTION"
            else -> ""
        }
        val subTitle = when(currentPage) {
            0 -> "척 70 시즈널 스웨이드 출시"
            1 -> "척테일러 올스타 리프트 클린 레더 하이 출시"
            2 -> "컨버스와 함께하는 스페셜 오퍼 UPTO 40%"
            else -> ""
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title,color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.W700)
            Text(text = subTitle, color = Color.DarkGray, fontSize = 20.sp, fontWeight = FontWeight.W300)
        }
    }
}

@Composable
private fun MainContainer() {

}