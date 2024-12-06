package com.example.travelapp.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.travelapp.R
import com.example.travelapp.components.PlaceView
import com.example.travelapp.components.PlanItem

@Composable
fun ParisScreen() {
    PlaceView(placeName = R.string.place_2, placeImage = R.drawable.paris_cover) {
        ParisPlans()
    }

}

private val PLANS_DATA = listOf(
    mapOf(
        "caption" to "День 1: Прибытие и знакомство",
        "activities" to listOf(
            "Заселиться в отель и освежиться",
            "Прогуляться по району, чтобы познакомиться с местностью",
            "Посетить Эйфелеву башню, желательно вечером, когда она подсвечена",
            "Поужинать в ближайшем ресторане"
        )
    ),
    mapOf(
        "caption" to "День 2: Искусство и история",
        "activities" to listOf(
            "Посетить Лувр и увидеть некоторые из самых известных произведений искусства",
            "Прогуляться по саду Тюильри и площади Согласия",
            "Посетить музей Орсе, где собрана большая коллекция импрессионистов",
            "Поужинать в местном французском ресторане"
        )
    ),
    mapOf(
        "caption" to "День 3: Французская культура и кухня",
        "activities" to listOf(
            "Посетить район Монмартр, чтобы увидеть базилику Сакре-Кёр и площадь Тертр",
            "Исследовать исторический район Ле Маре",
            "Попробовать вкуснейшие французские пирожные в местной пекарне",
            "Поужинать в брассери, чтобы попробовать классическую французскую кухню"
        )
    ),
    mapOf(
        "caption" to "День 4: Архитектура и сады",
        "activities" to listOf(
            "Посетить Версальский дворец, объект всемирного наследия ЮНЕСКО, и его красивые сады",
            "Прогуляться по Елисейским полям и остановиться у Триумфальной арки",
            "Посетить Сент-Шапель, великолепную готическую часовню с витражами",
            "Поужинать в местном ресторане в 7-м округе"
        )
    ),
    mapOf(
        "caption" to "День 5: Шопинг и достопримечательности",
        "activities" to listOf(
            "Посетить собор Нотр-Дам и подняться на вершину для потрясающего вида на город",
            "Исследовать Латинский квартал и посетить Пантеон",
            "Сходить за покупками в знаменитые магазины Galeries Lafayette или Printemps",
            "Поужинать в местном бистро"
        )
    ),
    mapOf(
        "caption" to "День 6: Парижские парки и музеи",
        "activities" to listOf(
            "Посетить музей Родена и его красивые сады",
            "Прогуляться по Люксембургскому саду и посетить Люксембургский дворец",
            "Посетить Центр Помпиду — музей современного искусства в районе Маре",
            "Поужинать в местном ресторане в Латинском квартале"
        )
    ),
    mapOf(
        "caption" to "День 7: Речная прогулка и прощание",
        "activities" to listOf(
            "Совершить прогулку на лодке по реке Сена, чтобы увидеть город с нового ракурса",
            "Посетить музей Оранжери, где выставлены знаменитые картины Моне с водяными лилиями",
            "Поужинать в ресторане с мишленовской звездой"
        )
    )
)


@Composable
private fun ParisPlans() {
    PLANS_DATA.forEach { plan ->
        @Suppress("UNCHECKED_CAST")
        PlanItem(
            caption = plan["caption"] as String,
            activities = plan["activities"] as List<String>
        )
    }
}

@Preview
@Composable
fun ParisPlansPreview() {
    PlaceView(placeName = R.string.place_2, placeImage = R.drawable.paris_cover) {
        ParisPlans()
    }
}
