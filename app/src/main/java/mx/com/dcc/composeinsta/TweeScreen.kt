import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.com.dcc.composeinsta.R
import mx.com.dcc.composeinsta.ui.theme.ComposeInstaTheme

@Composable
fun TwitterCard() {
    var chat by remember {
        mutableStateOf(false)
    }
    var retweet by remember {
        mutableStateOf(false)
    }
    var like by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF161D26))
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Image profile",
            modifier = Modifier
                .clip(
                    CircleShape
                )
                .size(55.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                TextTitle(title = "Name", modifier = Modifier.padding(end = 8.dp))
                TextDefault(title = "@username", modifier = Modifier.padding(end = 8.dp))
                TextDefault(title = "0H", modifier = Modifier.padding(end = 8.dp))
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.ic_dots),
                    contentDescription = "Menu options",
                    tint = Color.White
                )
            }
            TextBody(text = "Texto para un tweet", modifier = Modifier.padding(bottom = 8.dp))
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(
                        RoundedCornerShape(10)
                    ),
                contentScale = ContentScale.Crop
            )
            Row(modifier = Modifier.padding(top = 16.dp)) {
                SocialIcon(
                    modifier = Modifier.weight(1f),
                    unselectedIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_chat),
                            contentDescription = "Comment button",
                            tint = Color(0xFF7E8B98)
                        )
                    },
                    selectedIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_chat_filled),
                            contentDescription = "Comment button",
                            tint = Color(0xFF7E8B98)
                        )
                    },
                    isSelected = chat
                ) {
                    chat = !chat
                }
                SocialIcon(
                    modifier = Modifier.weight(1f),
                    unselectedIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_rt),
                            contentDescription = "Comment button",
                            tint = Color(0xFF7E8B98)
                        )
                    },
                    selectedIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_rt),
                            contentDescription = "Comment button",
                            tint = Color(0xFF00FF27)
                        )
                    },
                    isSelected = retweet
                ) {
                    retweet = !retweet
                }
                SocialIcon(
                    modifier = Modifier.weight(1f),
                    unselectedIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_like),
                            contentDescription = "Comment button",
                            tint = Color(0xFF7E8B98)
                        )
                    },
                    selectedIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_like_filled),
                            contentDescription = "Comment button",
                            tint = Color(0xFFFF0000)
                        )
                    },
                    isSelected = like
                ) {
                    like = !like
                }

            }
        }
    }
}

@Composable
fun TextTitle(title: String, modifier: Modifier = Modifier) {
    Text(text = title, color = Color.White, fontWeight = FontWeight.ExtraBold, modifier = modifier)
}

@Composable
fun TextDefault(title: String, modifier: Modifier = Modifier) {
    Text(text = title, color = Color.Gray, modifier = modifier)
}

@Composable
fun TextBody(text: String, modifier: Modifier = Modifier) {
    Text(text = text, color = Color.White, modifier = modifier)
}

@Composable
fun SocialIcon(
    modifier: Modifier,
    unselectedIcon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit,
    isSelected: Boolean,
    onItemSelected: () -> Unit
) {
    val defaultValue = 1
    Row(
        modifier = modifier.clickable { onItemSelected() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isSelected) {
            selectedIcon()
        } else {
            unselectedIcon()
        }
        val text = if (isSelected) "${defaultValue + 1}" else "$defaultValue"
        Text(
            text = text,
            color = Color(0xFF7E8B98),
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Composable
fun TweetDivider() {
    Divider(
        modifier = Modifier
            .padding(top = 4.dp)
            .height(0.5.dp)
            .fillMaxWidth(),
        color = Color(0xFF7E8B98)
    )
}

@Preview(showBackground = true)
@Composable
fun TwitterCardPreview() {
    ComposeInstaTheme {
        TwitterCard()
    }
}