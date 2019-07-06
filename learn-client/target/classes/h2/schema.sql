CREATE TABLE `device_online` (
                              `mac` varchar(12) NOT NULL,
                              `dmac` varchar(12) NOT NULL,
                              `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                              UNIQUE INDEX `mac_dmac`(`mac`, `dmac`) USING BTREE
);