import React, { Component } from 'react'
import UnderexcLimIEEE1Service from '../services/UnderexcLimIEEE1Service'

class ViewUnderexcLimIEEE1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            underexcLimIEEE1: {}
        }
    }

    componentDidMount(){
        UnderexcLimIEEE1Service.getUnderexcLimIEEE1ById(this.state.id).then( res => {
            this.setState({underexcLimIEEE1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View UnderexcLimIEEE1 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> kuc:&emsp; </label>
                            <div> { this.state.underexcLimIEEE1.kuc }</div>
                        </div>
                        <div className = "row">
                            <label> kuf:&emsp; </label>
                            <div> { this.state.underexcLimIEEE1.kuf }</div>
                        </div>
                        <div className = "row">
                            <label> kui:&emsp; </label>
                            <div> { this.state.underexcLimIEEE1.kui }</div>
                        </div>
                        <div className = "row">
                            <label> kul:&emsp; </label>
                            <div> { this.state.underexcLimIEEE1.kul }</div>
                        </div>
                        <div className = "row">
                            <label> kur:&emsp; </label>
                            <div> { this.state.underexcLimIEEE1.kur }</div>
                        </div>
                        <div className = "row">
                            <label> tu1:&emsp; </label>
                            <div> { this.state.underexcLimIEEE1.tu1 }</div>
                        </div>
                        <div className = "row">
                            <label> tu2:&emsp; </label>
                            <div> { this.state.underexcLimIEEE1.tu2 }</div>
                        </div>
                        <div className = "row">
                            <label> tu3:&emsp; </label>
                            <div> { this.state.underexcLimIEEE1.tu3 }</div>
                        </div>
                        <div className = "row">
                            <label> tu4:&emsp; </label>
                            <div> { this.state.underexcLimIEEE1.tu4 }</div>
                        </div>
                        <div className = "row">
                            <label> vucmax:&emsp; </label>
                            <div> { this.state.underexcLimIEEE1.vucmax }</div>
                        </div>
                        <div className = "row">
                            <label> vuimax:&emsp; </label>
                            <div> { this.state.underexcLimIEEE1.vuimax }</div>
                        </div>
                        <div className = "row">
                            <label> vuimin:&emsp; </label>
                            <div> { this.state.underexcLimIEEE1.vuimin }</div>
                        </div>
                        <div className = "row">
                            <label> vulmax:&emsp; </label>
                            <div> { this.state.underexcLimIEEE1.vulmax }</div>
                        </div>
                        <div className = "row">
                            <label> vulmin:&emsp; </label>
                            <div> { this.state.underexcLimIEEE1.vulmin }</div>
                        </div>
                        <div className = "row">
                            <label> vurmax:&emsp; </label>
                            <div> { this.state.underexcLimIEEE1.vurmax }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewUnderexcLimIEEE1Component
