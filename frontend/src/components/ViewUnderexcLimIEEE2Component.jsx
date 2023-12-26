import React, { Component } from 'react'
import UnderexcLimIEEE2Service from '../services/UnderexcLimIEEE2Service'

class ViewUnderexcLimIEEE2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            underexcLimIEEE2: {}
        }
    }

    componentDidMount(){
        UnderexcLimIEEE2Service.getUnderexcLimIEEE2ById(this.state.id).then( res => {
            this.setState({underexcLimIEEE2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View UnderexcLimIEEE2 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> k1:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.k1 }</div>
                        </div>
                        <div className = "row">
                            <label> k2:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.k2 }</div>
                        </div>
                        <div className = "row">
                            <label> kfb:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.kfb }</div>
                        </div>
                        <div className = "row">
                            <label> kuf:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.kuf }</div>
                        </div>
                        <div className = "row">
                            <label> kui:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.kui }</div>
                        </div>
                        <div className = "row">
                            <label> kul:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.kul }</div>
                        </div>
                        <div className = "row">
                            <label> p0:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.p0 }</div>
                        </div>
                        <div className = "row">
                            <label> p1:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.p1 }</div>
                        </div>
                        <div className = "row">
                            <label> p10:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.p10 }</div>
                        </div>
                        <div className = "row">
                            <label> p2:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.p2 }</div>
                        </div>
                        <div className = "row">
                            <label> p3:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.p3 }</div>
                        </div>
                        <div className = "row">
                            <label> p4:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.p4 }</div>
                        </div>
                        <div className = "row">
                            <label> p5:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.p5 }</div>
                        </div>
                        <div className = "row">
                            <label> p6:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.p6 }</div>
                        </div>
                        <div className = "row">
                            <label> p7:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.p7 }</div>
                        </div>
                        <div className = "row">
                            <label> p8:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.p8 }</div>
                        </div>
                        <div className = "row">
                            <label> p9:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.p9 }</div>
                        </div>
                        <div className = "row">
                            <label> q0:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.q0 }</div>
                        </div>
                        <div className = "row">
                            <label> q1:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.q1 }</div>
                        </div>
                        <div className = "row">
                            <label> q10:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.q10 }</div>
                        </div>
                        <div className = "row">
                            <label> q2:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.q2 }</div>
                        </div>
                        <div className = "row">
                            <label> q3:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.q3 }</div>
                        </div>
                        <div className = "row">
                            <label> q4:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.q4 }</div>
                        </div>
                        <div className = "row">
                            <label> q5:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.q5 }</div>
                        </div>
                        <div className = "row">
                            <label> q6:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.q6 }</div>
                        </div>
                        <div className = "row">
                            <label> q7:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.q7 }</div>
                        </div>
                        <div className = "row">
                            <label> q8:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.q8 }</div>
                        </div>
                        <div className = "row">
                            <label> q9:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.q9 }</div>
                        </div>
                        <div className = "row">
                            <label> tu1:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.tu1 }</div>
                        </div>
                        <div className = "row">
                            <label> tu2:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.tu2 }</div>
                        </div>
                        <div className = "row">
                            <label> tu3:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.tu3 }</div>
                        </div>
                        <div className = "row">
                            <label> tu4:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.tu4 }</div>
                        </div>
                        <div className = "row">
                            <label> tul:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.tul }</div>
                        </div>
                        <div className = "row">
                            <label> tup:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.tup }</div>
                        </div>
                        <div className = "row">
                            <label> tuq:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.tuq }</div>
                        </div>
                        <div className = "row">
                            <label> tuv:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.tuv }</div>
                        </div>
                        <div className = "row">
                            <label> vuimax:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.vuimax }</div>
                        </div>
                        <div className = "row">
                            <label> vuimin:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.vuimin }</div>
                        </div>
                        <div className = "row">
                            <label> vulmax:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.vulmax }</div>
                        </div>
                        <div className = "row">
                            <label> vulmin:&emsp; </label>
                            <div> { this.state.underexcLimIEEE2.vulmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewUnderexcLimIEEE2Component
