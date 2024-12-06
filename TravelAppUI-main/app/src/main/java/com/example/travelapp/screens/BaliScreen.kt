package com.example.travelapp.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.travelapp.R
import com.example.travelapp.components.PlaceView
import com.example.travelapp.components.PlanItem

@Composable
fun BaliScreen() {
    PlaceView(placeName = R.string.place_1, placeImage = R.drawable.bali_cover) {
        BaliPlans()
    }
}

private val PLANS_DATA = listOf(
    mapOf(
        "caption" to "День 1: Прибытие и отдых",
        "activities" to listOf(
            "Прибытие на Бали и заселение в отель или другое жилье.",
            "Посвятите день отдыху и акклиматизации на острове.",
            "Если будет время, исследуйте окрестности или отправьтесь на пляж."
        )
    ),
    mapOf(
        "caption" to "День 2: Тур по Убуду",
        "activities" to listOf(
            "Начните день с поездки в Убуд — культурный и художественный центр Бали.",
            "Посетите Лес Обезьян и дворец Убуда.",
            "Совершите экскурсию по рисовым террасам Тегалаланг, объекту Всемирного наследия ЮНЕСКО.",
            "Завершите день традиционным балийским танцевальным представлением."
        )
    ),
    mapOf(
        "caption" to "День 3: Храмы Бали",
        "activities" to listOf(
            "Посетите самые известные храмы Бали, такие как Танах Лот и Улувату.",
            "Насладитесь потрясающими видами на океан и скалы.",
            "Устройте ужин на закате в одном из ресторанов рядом с храмами."
        )
    ),
    mapOf(
        "caption" to "День 4: Водопады и пляжи",
        "activities" to listOf(
            "Совершите поездку к красивым водопадам Бали, таким как Тегенунган или Гитгит.",
            "Проведите день на одном из знаменитых пляжей Бали, таких как Семиньяк или Нуса-Дуа."
        )
    ),
    mapOf(
        "caption" to "День 5: Экскурсия на острова",
        "activities" to listOf(
            "Отправьтесь на экскурсию к соседним островам, таким как Нуса-Лембонган или Гили.",
            "Займитесь сноркелингом или дайвингом в кристально чистой воде и отдохните на пляже."
        )
    ),
    mapOf(
        "caption" to "День 6: Культурные мероприятия",
        "activities" to listOf(
            "Посетите традиционную балийскую деревню и узнайте больше об острове."
        )
    ),
    mapOf(
        "caption" to "День 7: Отъезд",
        "activities" to listOf(
            "Исследуйте окрестности и насладитесь великолепными закатами.",
            "Поужинайте в местном ресторане перед возвращением в жилье."
        )
    )
)

@Composable
private fun BaliPlans() {
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
fun BaliPlansPreview() {
    PlaceView(placeName = R.string.place_1, placeImage = R.drawable.bali_cover) {
        BaliPlans()
    }
}