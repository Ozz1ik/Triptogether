package com.example.travelapp.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.travelapp.R
import com.example.travelapp.components.PlaceView
import com.example.travelapp.components.PlanItem

@Composable
fun SingaporeScreen() {
    PlaceView(placeName = R.string.place_3, placeImage = R.drawable.singapore_cover) {
        SingaporePlans()
    }
}

private val PLANS_DATA = listOf(
    mapOf(
        "caption" to "День 1:",
        "activities" to listOf(
            "Посетите Сады у залива (Gardens by the Bay) и полюбуйтесь Супердеревьями, а также оранжереями Flower Dome и Cloud Forest.",
            "Исследуйте комплекс Marina Bay Sands, включающий казино, торговый центр класса люкс и смотровую площадку с потрясающим видом на город."
        )
    ),
    mapOf(
        "caption" to "День 2:",
        "activities" to listOf(
            "Изучите исторический район Чайнатаун, включая храм и музей Зуба Будды (Buddha Tooth Relic Temple) и храм Шри Мариамман (Sri Mariamman Temple).",
            "Посетите набережную Кларк-Ки (Clarke Quay), чтобы пообедать и исследовать ее рестораны, бары и магазины."
        )
    ),
    mapOf(
        "caption" to "День 3:",
        "activities" to listOf(
            "Совершите экскурсию по Ботаническим садам Сингапура (включенным в список объектов наследия ЮНЕСКО), одному из самых известных тропических садов в мире.",
            "Отправьтесь в Национальный музей Сингапура, где представлена богатая коллекция исторических и культурных артефактов."
        )
    ),
    mapOf(
        "caption" to "День 4:",
        "activities" to listOf(
            "Посетите Сингапурский зоопарк и полюбуйтесь дикой природой, включая орангутанов, тигров и слонов.",
            "Отправьтесь на остров Сентоза, чтобы отдохнуть на пляже или посетить такие аттракционы, как Universal Studios Singapore или аквапарк Adventure Cove."
        )
    ),
    mapOf(
        "caption" to "День 5:",
        "activities" to listOf(
            "Совершите прогулку по природе в заповеднике МаРичи (MacRitchie Reservoir), где есть тропы для пеших прогулок и захватывающие виды на городской пейзаж.",
            "Посетите Маленькую Индию (Little India), яркий и колоритный район с магазинами, храмами и уличной едой."
        )
    ),
    mapOf(
        "caption" to "День 6:",
        "activities" to listOf(
            "Исследуйте модный район Тионг Бару (Tiong Bahru), известный своими стильными кафе, бутиками и архитектурой в стиле ар-деко.",
            "Посетите Национальную галерею Сингапура, где представлена крупнейшая публичная коллекция современного искусства Сингапура и Юго-Восточной Азии."
        )
    ),
    mapOf(
        "caption" to "День 7:",
        "activities" to listOf(
            "Совершите однодневную поездку на остров Палау Убин (Pulau Ubin), где можно арендовать велосипед и исследовать традиционные деревни кампунг и природные тропы."
        )
    )
)

@Composable
private fun SingaporePlans() {
    PLANS_DATA.forEach { plan ->
        PlanItem(
            caption = plan["caption"] as String,
            activities = plan["activities"] as List<String>
        )
    }
}

@Preview
@Composable
fun SingaporePlansPreview() {
    PlaceView(placeName = R.string.place_3, placeImage = R.drawable.singapore_cover) {
        SingaporePlans()
    }
}
