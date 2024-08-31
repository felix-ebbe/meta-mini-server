IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "4096"
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"

EXTRA_IMAGE_FEATURES ?= "debug-tweaks"

ROCKCHIP_KERNEL_IMAGES = "1"

# Enable systemd
INIT_MANAGER = "systemd"

DISTRO_FEATURES:append = " virtualization"
DISTRO_FEATURES:remove = "ptest"
DISTRO_FEATURES:remove = "vulkan"
DISTRO_FEATURES:append = " egl"

IMAGE_INSTALL:append = " \
    alsa-utils \
    e2fsprogs \
    evtest \
    gptfdisk \
    i2c-tools \
    iperf3 \
    iw \
    kernel-modules \
    linux-firmware \
    minicom \
    packagegroup-core-full-cmdline \
    parted \
    pciutils \
    ppp \
    usbutils \
    libgpiod \
    libgpiod-dev \
    libgpiod-tools \
"

IMAGE_INSTALL:append = " \
    os-release \
    ifupdown \
    dhcpcd \
"

IMAGE_INSTALL:append = " \
    alsa-utils \
    pulseaudio-server \
    alsa-plugins-pulseaudio-conf \
"
