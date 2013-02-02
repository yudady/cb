<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<link type="text/css" rel="stylesheet" href='<c:url value="/resources/css/item.css"/>' />
<script type="text/javascript" src='<c:url value="/resources/js/page/item.js" />'></script>
<script type='text/javascript' src='<c:url value="/dwr/engine.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/util.js"/>'></script>
<script type='text/javascript' src='<c:url value="/dwr/interface/watch.js"/>'></script>
	<div id="HomePageOnly-top">
		<div id="sidebar">
			<jsp:include page="/sidebar" />
		</div>
<!-- bidding_left_column -->
		<div id="bidding_left_column">
		
			<div>
				<div>
					${item.difDay} day
				</div>
				<!-- time-tag -->
				<a href="#">
					<img src='<c:url value="/resources/upload/mainpic/${item.mainPictureLocation}" />' />
				</a>
			</div>
<!-- run -->		
<c:forEach items="${item.pictures}" var="picture">
	<img src='<c:url value="/resources/upload/mainpic/${picture.location}" />' height="50" width="75"/>
</c:forEach>
			<div id="tabs">
				<ul>
					<li><a href="#lotDetails">Lot Details </a></li>
					<li><a href="#legalTerms">Legal Terms</a></li>
					<li><a href="#shipping">Shipping</a></li>
				</ul>
				
				<div id="lotDetails">${item.lotDetails}</div>
				<div id="legalTerms">${item.legalTerms}</div>
				<div id="shipping">${item.shipping}</div>
			</div>
		</div>
<!-- bidding_left_column -->
<!-- bidding_right_column -->
		<div id="bidding_right_column">
			<div id="bidding_right_column">
				<h2>
					${item.title}
				</h2>
				<div>
					<a href='<c:url value="/" />'><i><span>Home</span></i></a> » <a href='<c:url value="/categories/${item.categoryId}" />'>Celebrity</a>
				</div>
<!-- bidInfo -->
				<div id="bidInfo">
					<div id="placeBid">
						<div>
							<div>Current Bid: 
								<span id="currentPrice">${item.currentBid}</span> 
								<span> ( <a href='<c:url value="/item/${item.id}/bidlog" />'>${item.numberBids}</a> )</span>
							</div>
							<div id="placedBy">
								placed by: <b>jaimervelasco</b>
							</div>
							<div>
								Estimated Value: <b> ${item.estimatedValue} </b>
							</div>
						</div>
						<div>
							${item.lotClose} - ${item.lotStart}     days left to bid
							<div>
								${item.lotClose} - ${item.lotStart}  Fri, 8 Feb 1:12PM EST 
								<a id="closingTimePop" href="#"><span>What's this?</span></a>
								<div id="closingTimePopDialog" title="Closing Time">
									This is the time the auction will end, but "Popcorn Bidding" could add 10 minutes to the closing time. If a bid is placed within 10 minutes of the closing time, the auction will extend by 10 minutes. This allows competing bidders a chance to stay in the race.
								</div>
							</div>
						</div>
<!-- currencyConverter -->
						<div id="currencyConverter">
							<a id="link-currency" href="#"> $ <small>▾</small></a>
							<input id="bid_amount" type="text" size="30" />
							<input id="bid_itemId" type="hidden" value="${item.id}" />
							<input id="bid_minNextBid" type="hidden" value="${item.minNextBid}" />
							<button id="bid_submit" type="button">Bid now</button>
						</div>
<!-- /currencyConverter -->
						<div id="popup-currency">
							<h4>Conversions Approximate</h4>
							<table cellspacing="0" cellpadding="0" border="0">
								<thead>
									<tr>
										<th class="country"></th>
										<th class="current">current bid</th>
										<th class="minNext">min next bid</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="country"><img width="21" height="13"
											src="http://assets2.charitybuzz.com/assets/0e1feffb2/images/lot_detail/flag-usd.png"
											alt="USD" /> USD</td>
										<td class="current">5,250</td>
										<td class="minNext">5,750</td>
									</tr>
									<tr>
										<td class="country"><img width="21" height="13"
											src="http://assets2.charitybuzz.com/assets/dc8326984/images/lot_detail/flag-eur.png"
											alt="EUR" /> EUR</td>
										<td class="current">3,933.38</td>
										<td class="minNext">4,307.99</td>
									</tr>
									<tr>
										<td class="country"><img width="21" height="13"
											src="http://assets2.charitybuzz.com/assets/b2d4a6216/images/lot_detail/flag-gbp.png"
											alt="GBP" /> GBP</td>
										<td class="current">3,309.54</td>
										<td class="minNext">3,624.73</td>
									</tr>
									<tr>
										<td class="country"><img width="21" height="14"
											src="http://assets2.charitybuzz.com/assets/a0086ec5a/images/lot_detail/flag-chf.png"
											alt="CHF" /> CHF</td>
										<td class="current">4,875.68</td>
										<td class="minNext">5,340.03</td>
									</tr>
									<tr>
										<td class="country"><img width="21" height="13"
											src="http://assets2.charitybuzz.com/assets/12bb4b56e/images/lot_detail/flag-jpy.png"
											alt="JPY" /> JPY</td>
										<td class="current">465,833</td>
										<td class="minNext">510,198</td>
									</tr>
									<tr>
										<td class="country"><img width="21" height="14"
											src="http://assets2.charitybuzz.com/assets/58b3ecd7f/images/lot_detail/flag-hkd.png"
											alt="HKD" /> HKD</td>
										<td class="current">40,703.51</td>
										<td class="minNext">44,580.04</td>
									</tr>
									<tr>
										<td class="country"><img width="21" height="15"
											src="http://assets2.charitybuzz.com/assets/4dc1ad336/images/lot_detail/flag-rub.png"
											alt="RUB" /> RUB</td>
										<td class="current">158,662.88</td>
										<td class="minNext">173,773.63</td>
									</tr>
									<tr>
										<td class="country"><img width="21" height="13"
											src="http://assets2.charitybuzz.com/assets/b83f5d43a/images/lot_detail/flag-cny.png"
											alt="CNY" /> CNY</td>
										<td class="current">32,680.20</td>
										<td class="minNext">35,792.60</td>
									</tr>
								</tbody>
							</table>
						</div>
						<!-- /popup-currency -->




						<div>
							you must bid at least 
							<span>${item.minNextBid}</span> 
							<a id="maxBidAndBidIncrementsPop" href="#"><span>What's this?</span></a>
							<div id="maxBidAndBidIncrementsPopDialog">
								<h2>Max Bid</h2>
								<p>This item supports Max Bidding! The bid you enter will
									automatically be a Max Bid. If your Max Bid is higher than the
									next Bid Increment, the bid will only be raised to the next Bid
									Increment. If someone else bids on this item for an amount less
									than your Max Bid, then you will automatically beat them and
									your bid will be increased to the Bid Increment necessary to
									beat them (or increased to your Max Bid itself, if that's
									lower).</p>
								<h2>Bid Increment</h2>
								<p>To keep bidding competitive and interesting, you are
									required to increase the bid by an amount comparable to the
									current bid itself. Here's the guide:</p>
								<table>
									<thead>
										<tr>
											<th>Current Bid Amount</th>
											<th>Bid Increment</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>250 or less</td>
											<td>25</td>
										</tr>
										<tr>
											<td>250 - 500</td>
											<td>50</td>
										</tr>
										<tr>
											<td>500 - 1000</td>
											<td>100</td>
										</tr>
										<tr>
											<td>1000 - 5000</td>
											<td>250</td>
										</tr>
										<tr>
											<td>5000 - 10000</td>
											<td>500</td>
										</tr>
										<tr>
											<td>10000 - 25000</td>
											<td>1000</td>
										</tr>
										<tr>
											<td>25000 - 50000</td>
											<td>2500</td>
										</tr>
										<tr>
											<td>50000 - 10000000</td>
											<td>5000</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div>Proceeds Benefit: 
						<a target="_blank" href="http://www.gardenofdreamsfoundation.org/">The Garden of Dreams Foundation</a>
					</div>
					<div id="watchQuestion">
					<c:choose>
						<c:when test="${isWatching}">
							<input type="checkbox" id="watchBox" name="watchBox" checked="checked" />
						</c:when>
						<c:otherwise>
							<input type="checkbox" id="watchBox" name="watchBox" />
						</c:otherwise>
					</c:choose>
						
						<ul>
							<li id="watch"><a>Watch This Item</a></li>
							<li><a href='<c:url value="/contact_us"/>'>Ask a Question</a></li>
						</ul>
					</div>
					<div id="more-details">
						<a href="#">More Details</a>
						<dl>
							<dt>Lot Number:</dt>
							<dd>${item.id}</dd>
							<dt>Estimated Value:</dt>
							<dd>${item.estimatedValue}</dd>
							<dt>Open Date</dt>
							<dd>${item.lotStart}</dd>
							<dt>Close Date:</dt>
							<dd>${item.lotClose}</dd>
						</dl>
					</div>
				</div>
<!-- bidInfo -->
			</div>
		</div>
<!-- bidding_right_column -->
	</div>