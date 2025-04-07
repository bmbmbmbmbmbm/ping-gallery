import { ImageList, ImageListItem, ImageListItemBar, Stack } from "@mui/material";
import useImageMetaList from "../hooks/useImageMetaList";

function Gallery() {
    const imageMetaList = useImageMetaList()

    return (
        <ImageList cols={5}>
            {imageMetaList.map(item => (
                <ImageListItem key={item.id}>
                    <img
                        src={`${item.uri}?w=164&h=164&fit=crop=format`}
                        alt={item.name}
                        loading="lazy"
                        id={item.id}
                    ></img>
                    <ImageListItemBar
                        title={item.name}
                        subtitle={<Subtitle imageMeta={item}></Subtitle>}
                        position="below"
                    ></ImageListItemBar>
                </ImageListItem>
            ))}
        </ImageList>
    )
}

interface ImageMetaProps {
    imageMeta: ImageMeta
}

function Subtitle({ imageMeta }: ImageMetaProps) {
    return (
        <Stack>
            <span>Created: {imageMeta.created}</span>
            <span>Size: {imageMeta.size}</span>
        </Stack>
    )
}

export default Gallery