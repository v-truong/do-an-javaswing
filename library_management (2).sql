-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 24, 2022 lúc 09:04 AM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `library_management`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `AccountID` int(11) NOT NULL COMMENT 'ID chủ tài khoản',
  `AccountName` varchar(255) NOT NULL DEFAULT '' COMMENT 'Tên chủ tài khoản',
  `Username` varchar(150) DEFAULT NULL COMMENT 'Tài khoản',
  `Password` varchar(100) DEFAULT NULL COMMENT 'Mật khẩu',
  `Description` text DEFAULT NULL COMMENT 'Thông tin thêm',
  `PhoneNo` varchar(20) NOT NULL DEFAULT '' COMMENT 'Số điện thoại',
  `RoleID` smallint(3) DEFAULT NULL COMMENT 'ID phân quyền',
  `CreatedDate` datetime DEFAULT NULL COMMENT 'Ngày tạo',
  `CreatedBy` varchar(255) DEFAULT NULL COMMENT 'Người tạo',
  `ModifiedDate` datetime DEFAULT NULL COMMENT 'Ngày sửa',
  `ModifiedBy` varchar(255) DEFAULT NULL COMMENT 'Người sửa'
) ENGINE=InnoDB AVG_ROW_LENGTH=2730 DEFAULT CHARSET=utf8mb4 COMMENT='Bảng chứa thông tin người dùng';

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`AccountID`, `AccountName`, `Username`, `Password`, `Description`, `PhoneNo`, `RoleID`, `CreatedDate`, `CreatedBy`, `ModifiedDate`, `ModifiedBy`) VALUES
(1, 'Admin', 'admin', 'admin', '', '0375877699', 1, '2022-12-07 23:19:06', 'Admin', '2022-12-07 23:19:06', 'Admin'),
(2, 'User1', 'user1', 'user1', '', '0375877699', 2, '2022-12-07 23:19:06', 'User', '2022-12-07 23:19:06', 'User'),
(3, 'User2', 'user2', 'user2', '', '0375877699', 2, '2022-12-07 23:19:06', 'User', '2022-12-07 23:19:06', 'User'),
(4, 'User3', 'user3', 'user3', '', '0375877699', 2, '2022-12-07 23:19:06', 'User', '2022-12-07 23:19:06', 'User'),
(5, 'User4', 'user4', 'user4', '', '0375877699', 2, '2022-12-07 23:19:06', 'User', '2022-12-07 23:19:06', 'User'),
(6, 'User5', 'user5', 'user5', '', '0375877699', 2, '2022-12-07 23:19:06', 'User', '2022-12-07 23:19:06', 'User'),
(7, 'ádfasdf', 'gggg', 'ggg', 'dfgdfgd', '32123', 2, '2022-12-21 18:38:58', 'Admin', '2022-12-21 18:38:58', 'Admin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `author`
--

CREATE TABLE `author` (
  `AuthorID` int(11) NOT NULL COMMENT 'ID tác giả',
  `AuthorName` varchar(255) DEFAULT NULL COMMENT 'Tên tác giả',
  `Description` text DEFAULT NULL COMMENT 'Thông tin thêm',
  `CreatedDate` datetime DEFAULT NULL COMMENT 'Ngày tạo',
  `CreatedBy` varchar(255) DEFAULT NULL COMMENT 'Người tạo',
  `ModifiedDate` datetime DEFAULT NULL COMMENT 'Ngày sửa',
  `ModifiedBy` varchar(255) DEFAULT NULL COMMENT 'Người sửa'
) ENGINE=InnoDB AVG_ROW_LENGTH=3276 DEFAULT CHARSET=utf8mb4 COMMENT='Bảng lưu trữ thông tin tác giả';

--
-- Đang đổ dữ liệu cho bảng `author`
--

INSERT INTO `author` (`AuthorID`, `AuthorName`, `Description`, `CreatedDate`, `CreatedBy`, `ModifiedDate`, `ModifiedBy`) VALUES
(1, 'Ernest Miller Hemingway', 'Ernest Hemingway (1899 - 1961) là nhà văn, nhà báo người Mỹ. Ông từng tham gia chiến đấu trong Chiến tranh thế giới lần thứ I, sau đó được biết đến qua \"Thế hệ đã mất\". Ông nhận được giải thưởng báo chí Pulitzer năm 1953 và giải Nobel văn học năm 1954.', '2022-12-12 00:00:00', 'Admin', '2022-12-12 00:00:00', 'Admin'),
(2, ' Franz Kafka', 'Nhắc đến Franz Kafka, chúng ta nhớ tới sự dị biệt trong phong cách sáng tác rất đặc trưng của ông. Tác giả sinh năm 1883 trong một gia đình Do Thái nói tiếng Đức ở Praha, Cộng hòa Séc, trước đây thuộc đế quốc Áo Hung. Từ nhỏ, Kafka đã có niềm khao khát mãnh liệt với văn chương nhưng điều đó là bất khả trong mắt của cha ông, người kỳ vọng con trai trở thành trụ cột vững chãi trong gia đình.', '2022-12-12 00:00:00', 'Admin', '2022-12-12 00:00:00', 'Admin'),
(3, 'J.R.R.Tolkien', 'J.R.R.Tolkien sinh năm 1892 và mất vào năm 1973, là một trong những tác giả nổi tiếng trong dòng văn học siêu thực. 2 tác phẩm được biết tới nhiều nhất của ông là “anh chàng Hobbit” và “Chúa tể của những chiếc nhẫn”.', '2022-12-12 00:00:00', 'Admin', '2022-12-12 00:00:00', 'Admin'),
(4, 'Gabriel Garcia Marquez', 'Gabriel Garcia Marquez (sinh năm 1927) tại Aracataca, một thị trấn bên bờ biển Caribê, thuộc miền Bắc Columbia, ông là nhà văn nổi tiếng người Colombia. Ngoài viết văn ông còn là một nhà báo và một nhà hoạt động chính trị. Từ đầu năm 1965, ông bắt đầu viết tác phẩm quan trọng nhất của đời mình: “Trăm năm cô đơn”. Sau 18 tháng đóng cửa miệt mài viết, tác phẩm đã hoàn thành cũng là lúc tình trạng tài chính gia đình ông vô cùng khó khăn. Năm 1967, cuốn tiểu thuyết này được xuất bản và ngay lập tức dành được những thành công vang dội, được cả giới phê bình và độc giả mến mộ.', '2022-12-12 00:00:00', 'Admin', '2022-12-12 00:00:00', 'Admin'),
(5, 'Harper Lee', 'Harper Lee sinh năm 1926 và lớn lên ở Monroeville, bà thích viết truyện ngắn và các tác phẩm khác xoay quanh vấn đề ít được bàn luận ở trường học thời bấy giờ: kỳ thị chủng tộc. Harper Lee bỏ ra hai năm rưỡi để viết tiểu thuyết “Giết Con Chim Nhại”. Cuốn sách được xuất bản ngày 11 tháng 7 năm 1960. Lúc đầu được đặt tên là Atticus nhưng sau đó đã đổi lại để cho thấy một câu chuyện vượt qua khuôn khổ chân dung về một nhân vật.', '2022-12-12 00:00:00', 'Admin', '2022-12-12 00:00:00', 'Admin'),
(6, 'aaa', 'aaa', '2022-12-19 16:22:00', 'Admin', '2022-12-19 16:22:00', 'Admin'),
(7, 'ooo', 'oooo', '2022-12-20 09:27:49', 'Admin', '2022-12-20 09:27:49', 'Admin'),
(8, 'aaaa', 'aaaavvvv', '2022-12-20 14:29:21', 'Admin', '2022-12-20 14:48:46', 'Admin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `book`
--

CREATE TABLE `book` (
  `BookID` int(11) NOT NULL COMMENT 'Id sách',
  `BookName` varchar(255) NOT NULL DEFAULT '' COMMENT 'Tên sách',
  `Description` text DEFAULT NULL COMMENT 'Ghi chú',
  `CategoryID` int(11) DEFAULT NULL,
  `AuthorID` int(11) DEFAULT NULL COMMENT 'Tác giả',
  `PublisherID` int(11) DEFAULT NULL COMMENT 'Nhà sản xuất',
  `PublishDate` date DEFAULT NULL COMMENT 'Ngày xuất bản',
  `Price` decimal(14,2) NOT NULL COMMENT 'Giá',
  `Quantity` int(11) NOT NULL COMMENT 'Số lượng',
  `CreatedDate` datetime DEFAULT NULL COMMENT 'Ngày tạo',
  `CreatedBy` varchar(255) DEFAULT NULL COMMENT 'Người tạo',
  `ModifiedDate` datetime DEFAULT NULL COMMENT 'Ngày sửa',
  `ModifiedBy` varchar(255) DEFAULT NULL COMMENT 'Người sửa'
) ENGINE=InnoDB AVG_ROW_LENGTH=1489 DEFAULT CHARSET=utf8mb4 COMMENT='Bảng thông tin sách';

--
-- Đang đổ dữ liệu cho bảng `book`
--

INSERT INTO `book` (`BookID`, `BookName`, `Description`, `CategoryID`, `AuthorID`, `PublisherID`, `PublishDate`, `Price`, `Quantity`, `CreatedDate`, `CreatedBy`, `ModifiedDate`, `ModifiedBy`) VALUES
(1, 'Ông già và biển cả', ' “Ông già và biển cả”: Nguyên lý “tảng băng trôi” - một phần nổi, bảy phần chìm - được tác giả sử dụng triệt để trong tác phẩm “Ông già và biển cả”, tạo nên một mạch ngầm văn bản với các lớp nghĩa chưa được phô bày. Tác phẩm là bản anh hùng ca ca ngợi sức lao động và khát vọng của con người.', 6, 1, 1, '2021-06-16', '60.00', 1000, '2022-12-12 00:00:00', 'Admin', '2022-12-16 00:00:00', 'Admin'),
(2, 'Chuông nguyện hồn ai', ' “Chuông nguyện hồn ai”: là đỉnh cao trong cuộc đời sáng tác của Ernest Hemingway cũng như tác phẩm văn học nước ngoài hay và kinh điển mà bạn nên đọc.', 4, 1, 3, '2021-05-08', '60.00', 1000, '2022-12-12 00:00:00', 'Admin', '2022-12-16 00:00:00', 'Admin'),
(3, 'Lâu đài', ' “Lâu đài” là “viên ngọc bí ẩn” và đẹp nhất trong những tác phẩm lớn còn lại của Kafka. Huyền hoặc như một giấc mơ phi lý nhưng tột cùng chân thực, đó là những dòng “sấm truyền” mở đầu cho một thế kỷ 20 đầy đại họa mãi lâu sau thế giới mới biết đến.', 3, 2, 10, '2022-08-16', '60.00', 1000, '2022-12-12 00:00:00', 'Admin', '2022-12-16 00:00:00', 'Admin'),
(4, 'Hóa thân', ' “Hóa thân” là câu chuyện xoay quanh một nhân vật có tên Gregor Samsa, một ngày kia bỗng bị “biến hình” trở thành một con bọ khổng lồ. Dù mang trong mình một câu chuyện chứa đầy nỗi thống khổ, Franz Kafka vẫn giữ được cho tác phẩm một thứ văn phong giản dị, súc tích, gọn gàng, miêu tả cảm xúc một cách tinh tế.', 7, 2, 8, '2022-03-12', '60.00', 1000, '2022-12-12 00:00:00', 'Admin', '2022-12-16 00:00:00', 'Admin'),
(5, 'Chúa tể những chiếc nhẫn', 'Chúa tể những chiếc nhẫn-  cuốn sách được viết vào những năm 1950 và nhanh chóng trở nên phổ biến trên khắp thế giới, sau này được chuyển thể thành phim. Cuốn sách được lấy cảm hứng từ nhiều nguồn, bao gồm các lời tiên tri, huyền thoại, truyền thuyết, lịch sử, tôn giáo và tu luyện, tạo thành một tác phẩm đặc sắc mà bạn không thể bỏ sót từng câu chữ.', 6, 3, 1, '2020-12-16', '60.00', 1000, '2022-12-12 00:00:00', 'Admin', '2022-12-16 00:00:00', 'Admin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `borrowing`
--

CREATE TABLE `borrowing` (
  `BookID` int(11) NOT NULL COMMENT 'ID sách',
  `AccountID` int(11) NOT NULL COMMENT 'ID người dùng',
  `BorrowedDate` datetime DEFAULT NULL COMMENT 'Ngày mượn',
  `Status` smallint(3) NOT NULL COMMENT 'Trạng thái',
  `ReturnTime` datetime DEFAULT NULL COMMENT 'Ngày trả',
  `CreatedDate` datetime DEFAULT NULL COMMENT 'Ngày tạo',
  `CreatedBy` varchar(255) DEFAULT NULL COMMENT 'Người tạo',
  `ModifiedDate` datetime DEFAULT NULL COMMENT 'Ngày sửa',
  `ModifiedBy` varchar(255) DEFAULT NULL COMMENT 'Người tạo'
) ENGINE=InnoDB AVG_ROW_LENGTH=3276 DEFAULT CHARSET=utf8mb4 COMMENT='Bảng chứa thông tin mượn sách';

--
-- Đang đổ dữ liệu cho bảng `borrowing`
--

INSERT INTO `borrowing` (`BookID`, `AccountID`, `BorrowedDate`, `Status`, `ReturnTime`, `CreatedDate`, `CreatedBy`, `ModifiedDate`, `ModifiedBy`) VALUES
(1, 2, '2022-12-16 00:00:00', 1, '2022-12-16 19:30:32', '2022-12-16 00:00:00', 'Admin', '2022-12-22 15:41:49', 'Admin'),
(2, 1, '2022-12-12 08:08:00', 1, '2022-12-12 08:08:00', '2022-12-22 13:31:17', 'Admin', '2022-12-22 15:41:47', 'Admin'),
(2, 2, '2022-12-21 08:14:00', 1, '2022-12-21 08:14:00', '2022-12-21 20:12:33', 'Admin', '2022-12-24 14:46:00', 'Admin'),
(2, 4, '2022-12-16 00:00:00', 1, '2022-12-16 19:30:32', '2022-12-16 00:00:00', 'Admin', '2022-12-16 00:00:00', 'Admin'),
(3, 6, '2022-12-16 00:00:00', 0, '2022-12-16 19:30:32', '2022-12-16 00:00:00', 'Admin', '2022-12-24 14:51:43', 'Admin'),
(4, 3, '2022-12-16 00:00:00', 1, '2022-12-16 19:30:32', '2022-12-16 00:00:00', 'Admin', '2022-12-22 15:40:33', 'Admin'),
(5, 2, '2022-08-08 11:11:00', 0, '2022-08-08 11:11:00', '2022-12-22 13:41:52', 'Admin', '2022-12-24 14:51:55', 'Admin'),
(5, 5, '2022-12-16 00:00:00', 1, '2022-12-16 19:30:32', '2022-12-16 00:00:00', 'Admin', '2022-12-24 14:48:35', 'Admin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `CategoryID` int(11) NOT NULL COMMENT 'ID loại sách',
  `CategoryName` varchar(255) NOT NULL DEFAULT '' COMMENT 'Tên loại sách',
  `Description` text DEFAULT NULL COMMENT 'Thông tin thêm',
  `CreatedDate` datetime DEFAULT NULL COMMENT 'Ngày tạo',
  `CreatedBy` varchar(255) DEFAULT NULL COMMENT 'Người tạo',
  `ModifiedDate` datetime DEFAULT NULL COMMENT 'Ngày sửa',
  `ModifiedBy` varchar(255) DEFAULT NULL COMMENT 'Người sửa'
) ENGINE=InnoDB AVG_ROW_LENGTH=1638 DEFAULT CHARSET=utf8mb4 COMMENT='Bảng thế loại sách';

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`CategoryID`, `CategoryName`, `Description`, `CreatedDate`, `CreatedBy`, `ModifiedDate`, `ModifiedBy`) VALUES
(1, 'Tình cảm', 'Độc giả có xu hướng trung thành với tác giả yêu thích của họ trong thể loại lãng mạn. Các nhánh phụ trong thể loại sách lãng mạn phổ biến còn bao gồm các ấn phẩm tiểu thuyết lãng mạn huyền bí và lãng mạng mang tính lịch sử.', '2022-12-16 00:00:00', 'Admin', '2022-12-16 00:00:00', 'Admin'),
(2, 'Bí Ẩn', 'Tiểu thuyết bí ẩn bắt đầu bằng một câu chuyện hấp dẫn, khiến người đọc thích thú với nhịp độ hồi hộp và kết thúc bằng một cái kết thỏa mãn trả lời tất cả các câu hỏi nổi bật của người đọc.', '2022-12-16 00:00:00', 'Admin', '2022-12-16 00:00:00', 'Admin'),
(3, 'Khoa học viễn tưởng', 'Sách giả tưởng thường diễn ra trong một khoảng thời gian khác với thời gian hiện tại của chúng ta. Chúng thường có các sinh vật huyền bí, từ pháp sư / phù thuỷ cho đến những thây ma không có thật.', '2022-12-16 00:00:00', 'Admin', '2022-12-16 00:00:00', 'Admin'),
(4, 'Kinh dị', 'Các thể loại sách này bao gồm các ấn phẩm thường có mối liên hệ mật thiết đến những thể loại sách Mystery và đôi khi là giả tưởng – Fantasy, yếu tố ly kỳ và kinh dị tạo nên sự hồi hộp và điểm nổi bật của thể loại sách phổ biến này. Các tác giả như David Baldacci và Dan Brown là một trong những ngòi bút thống trị danh sách sách bán chạy nhất với các tựa phim kinh dị của họ, trong khi Stephen King lại là bậc thầy của thể loại kinh dị đương đại.', '2022-12-16 00:00:00', 'Admin', '2022-12-16 00:00:00', 'Admin'),
(5, 'Sách truyền cảm hứng', 'Các thể loại sách được sáng tác dựa trên các trải nghiệm thực tế này ngày càng tiếp cận được đông đảo khán giả trên toàn thế giới. Nhiều cuốn sách về self-help liên quan đến các bài học thành công trong kinh doanh hoặc bí quyết kinh doanh hiện đang đứng dầu trong các danh sách Best Sellers của thị trường này', '2022-01-16 00:00:00', 'Admin', '2022-12-16 00:00:00', 'Admin'),
(6, 'Tiểu sử', 'Đây là các thể loại sách phi hư cấu dùng để kể những câu chuyện về cuộc đời của một người. Trong trường hợp tự truyện và hồi ký, chủ thể sẽ là tác giả của cuốn sách. Tuy nhiên, danh mục tiểu sử lại có thể được viết bởi một người nào đó có quan tâm và tìm hiểu đến nhân vật, chứ không nhất thiết phải là chủ thể được nhắc đến trong cuốn sách.', '2022-12-16 00:00:00', 'Admin', '2022-12-16 00:00:00', 'Admin'),
(7, 'Truyện ngắn', 'Mặc dù chúng bao gồm các thể loại sách mà chúng tôi mô tả ở đây, truyện ngắn là văn xuôi ngắn gọn, tốt, ngắn hơn đáng kể so với tiểu thuyết. Các nhà văn kể câu chuyện của họ một cách nghiêm túc thông qua một chủ đề cụ thể và một loạt các cảnh ngắn gọn, mặc dù nhiều tác giả đã biên soạn những câu chuyện này trong các bộ sưu tập rộng rãi, như được giới thiệu bên dưới.', '2022-12-16 00:00:00', 'Admin', '2022-12-16 00:00:00', 'Admin'),
(8, 'Sách dạy nấu ăn', 'Các thể loại sách này, theo truyền thống được viết bởi các đầu bếp chuyên nghiệp hoặc thậm chí những người nổi tiếng yêu thích của bạn, sách dạy nấu ăn cung cấp một bộ sưu tập các công thức nấu ăn hấp dẫn, cụ thể cho một chủ đề, ẩm thực hoặc trải nghiệm do tác giả lựa chọn.', '2022-12-16 00:00:00', 'Admin', '2022-12-16 00:00:00', 'Admin'),
(9, 'Bài luận', 'Các thể loại sách này thông thường được viết ở ngôi thứ nhất, người viết sử dụng kinh nghiệm cá nhân của chính họ để phản ánh về một chủ đề hoặc chủ đề cho người đọc. Nhiều tác giả nổi tiếng – như James Baldwin và Toni Morrison – kết hợp những tác phẩm này thành bộ sưu tập bình luận xã hội.', '2022-12-16 00:00:00', 'Admin', '2022-12-16 00:00:00', 'Admin'),
(10, 'Sách lịch sử', 'Người ta thường nói rằng lịch sử là thứ mà chúng ta tạo ra từ nó, tuy nhiên, bây giờ nó có vẻ là một điều rất tao nhã để nói hơn là một điều thực tế. Nhưng có một điều khá chắc chắn, những người không thể nhớ quá khứ sẽ bị lên án là sẽ lặp lại nó (George Santayana).', '2022-12-16 00:00:00', 'Admin', '2022-12-16 00:00:00', 'Admin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `publisher`
--

CREATE TABLE `publisher` (
  `PublisherID` int(11) NOT NULL COMMENT 'ID nhà xuất bản',
  `PublisherName` varchar(255) NOT NULL DEFAULT '' COMMENT 'Tên nhà xuất bản',
  `Description` text DEFAULT NULL COMMENT 'Thông tin thêm',
  `CreatedDate` datetime DEFAULT NULL COMMENT 'Ngày tạo',
  `CreatedBy` varchar(255) DEFAULT NULL COMMENT 'Người tạo',
  `ModifiedDate` datetime DEFAULT NULL COMMENT 'Ngày sửa',
  `ModifiedBy` varchar(255) DEFAULT NULL COMMENT 'Người sửa'
) ENGINE=InnoDB AVG_ROW_LENGTH=1638 DEFAULT CHARSET=utf8mb4 COMMENT='Bảng chứa thông tin nhà xuất bản';

--
-- Đang đổ dữ liệu cho bảng `publisher`
--

INSERT INTO `publisher` (`PublisherID`, `PublisherName`, `Description`, `CreatedDate`, `CreatedBy`, `ModifiedDate`, `ModifiedBy`) VALUES
(1, 'RELX Group', 'Elsevier ngày nay được xem là nhà xuất bản (NXB) ấn phẩm khoa học lớn nhất thế giới. NXB có trụ sở tại thủ đô Hà Lan, sở hữu khoảng 2.500 tạp chí khoa học đa lĩnh vực với đội ngũ các chuyên gia tham gia ban biên tập lên đến 20.000 người. Mỗi năm, Elsevier “cho ra lò” chừng 420.000 bài báo khoa học đã qua bình duyệt, với gần 1 tỷ lượt tải báo.', '2022-12-16 00:00:00', 'Admin', '2022-12-16 00:00:00', 'Admin'),
(2, 'Pearson', 'Pearson Education là công ty giáo dục và xuất bản sách đa quốc gia lớn nhất thế giới có trụ sở tại London. Nó được thành lập như một doanh nghiệp xây dựng vào những năm 1840, nhưng đã chuyển sang xuất bản vào những năm 1920. Tại Việt Nam, Pearson Education được biết đến như một nhà xuất bản sách chuyên về sách tiếng Anh để giúp người đọc thực hành và nâng cao từng kỹ năng như: viết, đánh vần, sử dụng, từ điển đồng nghĩa, Ielts, Toeic, ELT, ...', '2022-12-16 00:00:00', 'Admin', '2022-12-16 00:00:00', 'Admin'),
(3, 'ThomsonReuters', 'Thomson Reuters cung cấp những thông tin quan trọng của các ngành công nghiệp tới nhà quản lý hàng đầu trong lĩnh vực tài chính, kế toán, khoa học, luật pháp, thuế, y tế, thị trường, truyền thông... Nhiều ấn phẩm của tập đoàn đã được chuyển qua phần mềm độc quyền, nổi bật là Westlaw - một dịch vụ nghiên cứu pháp lý trực tuyến, cơ sở dữ liệu độc quyền cho luật sư. Ứng dụng đã có mặt tại hơn 60 quốc gia.', '2022-12-16 00:00:00', 'Admin', '2022-12-16 00:00:00', 'Admin'),
(4, 'Bertelsmann', 'Bertelsmann là một tập đoàn đa quốc gia tư nhân của Đức có trụ sở tại Gütersloh, North Rhine-Westphalia, Đức. Nó là một trong những tập đoàn truyền thông lớn nhất thế giới và cũng hoạt động trong lĩnh vực dịch vụ và giáo dục. Bertelsmann được Carl Bertelsmann thành lập như một nhà xuất bản vào năm 1835. Sau Thế chiến thứ hai, Bertelsmann, dưới sự lãnh đạo của Reinhard Mohn, đã từ một doanh nghiệp cỡ vừa trở thành một tập đoàn lớn, không chỉ cung cấp sách mà còn cả truyền hình, đài phát thanh, âm nhạc, tạp chí và dịch vụ.', '2022-12-16 00:00:00', 'Admin', '2022-12-16 00:00:00', 'Admin'),
(5, 'Wolters Kluwer', 'Wolters Kluwer là một công ty dịch vụ thông tin Hà Lan - Mỹ. Công ty có trụ sở chính tại Alphen aan den Rijn, Hà Lan và Philadelphia, Hoa Kỳ. Wolters Kluwer được thành lập vào năm 1987 với sự hợp nhất giữa Kluwer Publishers và Wolters Samsom. Lĩnh vực xuất bản chủ yếu là các thị trường pháp lý, kinh doanh, thuế, kế toán, tài chính, kiểm toán, rủi ro, tuân thủ và chăm sóc sức khỏe.', '2022-12-16 00:00:00', 'Admin', '2022-12-16 00:00:00', 'Admin'),
(8, 'Wiley', 'Wiley là một tập đoàn lớn trong ngành xuất bản phẩm khoa học có truyền thống lâu đời hơn 200 năm. Ban đầu, Wiley theo đuổi dòng ấn phẩm luật pháp, tôn giáo, văn học hư cấu và hiện thực. Sau này, Wiley chuyển hẳn sang các ấn phẩm thuần tuý khoa học, kỹ thuật và công nghệ.', '2022-12-16 00:00:00', 'Admin', '2022-12-16 00:00:00', 'Admin'),
(10, 'Scholastic', 'Scholastic (hoặc Scholastic Inc.) là một công ty xuất bản sách toàn cầu được biết đến với việc sản xuất các mặt hàng giáo dục cho trường học, giáo viên và phụ huynh, và bán và cho họ bằng cách đặt hàng qua thư và thông qua các câu lạc bộ sách và hội chợ sách. Nó cũng có tất cả các quyền xuất bản cho bộ sách Harry Potter ở Hoa Kỳ.', '2022-12-16 00:00:00', 'Admin', '2022-12-16 00:00:00', 'Admin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role`
--

CREATE TABLE `role` (
  `RoleID` smallint(3) NOT NULL COMMENT 'ID phân quyền',
  `RoleName` varchar(255) NOT NULL DEFAULT '' COMMENT 'Tên phân quyền',
  `CreatedDate` datetime DEFAULT NULL COMMENT 'Ngày tạo',
  `CreatedBy` varchar(255) DEFAULT NULL COMMENT 'Người tạo',
  `ModifiedDate` datetime DEFAULT NULL COMMENT 'Ngày sửa',
  `ModifiedBy` varchar(255) DEFAULT NULL COMMENT 'Người sửa'
) ENGINE=InnoDB AVG_ROW_LENGTH=8192 DEFAULT CHARSET=utf8mb4 COMMENT='Bảng chứa phân quyền';

--
-- Đang đổ dữ liệu cho bảng `role`
--

INSERT INTO `role` (`RoleID`, `RoleName`, `CreatedDate`, `CreatedBy`, `ModifiedDate`, `ModifiedBy`) VALUES
(1, 'Admin', '2022-12-07 23:17:44', 'Admin', '2022-12-07 23:17:44', 'Admin'),
(2, 'User', '2022-12-07 23:17:44', 'Admin', '2022-12-07 23:17:44', 'Admin');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`AccountID`),
  ADD KEY `FK_account_RoleID` (`RoleID`);

--
-- Chỉ mục cho bảng `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`AuthorID`);

--
-- Chỉ mục cho bảng `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`BookID`),
  ADD KEY `FK_book_AuthorID` (`AuthorID`),
  ADD KEY `FK_book_CategoryID` (`CategoryID`),
  ADD KEY `FK_book_PublishierID` (`PublisherID`);

--
-- Chỉ mục cho bảng `borrowing`
--
ALTER TABLE `borrowing`
  ADD PRIMARY KEY (`BookID`,`AccountID`),
  ADD KEY `FK_borrowing_AccountID` (`AccountID`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`CategoryID`);

--
-- Chỉ mục cho bảng `publisher`
--
ALTER TABLE `publisher`
  ADD PRIMARY KEY (`PublisherID`);

--
-- Chỉ mục cho bảng `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`RoleID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `account`
--
ALTER TABLE `account`
  MODIFY `AccountID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID chủ tài khoản', AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `author`
--
ALTER TABLE `author`
  MODIFY `AuthorID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID tác giả', AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `book`
--
ALTER TABLE `book`
  MODIFY `BookID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id sách', AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `CategoryID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID loại sách', AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `publisher`
--
ALTER TABLE `publisher`
  MODIFY `PublisherID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID nhà xuất bản', AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT cho bảng `role`
--
ALTER TABLE `role`
  MODIFY `RoleID` smallint(3) NOT NULL AUTO_INCREMENT COMMENT 'ID phân quyền', AUTO_INCREMENT=3;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `FK_account_RoleID` FOREIGN KEY (`RoleID`) REFERENCES `role` (`RoleID`) ON DELETE NO ACTION;

--
-- Các ràng buộc cho bảng `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `FK_book_AuthorID` FOREIGN KEY (`AuthorID`) REFERENCES `author` (`AuthorID`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_book_CategoryID` FOREIGN KEY (`CategoryID`) REFERENCES `category` (`CategoryID`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_book_PublishierID` FOREIGN KEY (`PublisherID`) REFERENCES `publisher` (`PublisherID`) ON DELETE CASCADE;

--
-- Các ràng buộc cho bảng `borrowing`
--
ALTER TABLE `borrowing`
  ADD CONSTRAINT `FK_borrowing_AccountID` FOREIGN KEY (`AccountID`) REFERENCES `account` (`AccountID`) ON DELETE NO ACTION,
  ADD CONSTRAINT `FK_borrowing_BookID` FOREIGN KEY (`BookID`) REFERENCES `book` (`BookID`) ON DELETE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
