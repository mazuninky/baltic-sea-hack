package sea.hack.club.graphql.types.point

/*
input InputUpdatePointType {
id: Int
title: String
lang: Float
long: Float
}
 */
data class InputUpdatePointType(val id: Int,
                                val title: String,
                                val lang: Float,
                                val long: Float)
