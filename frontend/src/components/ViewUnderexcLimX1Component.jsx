import React, { Component } from 'react'
import UnderexcLimX1Service from '../services/UnderexcLimX1Service'

class ViewUnderexcLimX1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            underexcLimX1: {}
        }
    }

    componentDidMount(){
        UnderexcLimX1Service.getUnderexcLimX1ById(this.state.id).then( res => {
            this.setState({underexcLimX1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View UnderexcLimX1 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> k:&emsp; </label>
                            <div> { this.state.underexcLimX1.k }</div>
                        </div>
                        <div className = "row">
                            <label> kf2:&emsp; </label>
                            <div> { this.state.underexcLimX1.kf2 }</div>
                        </div>
                        <div className = "row">
                            <label> km:&emsp; </label>
                            <div> { this.state.underexcLimX1.km }</div>
                        </div>
                        <div className = "row">
                            <label> melmax:&emsp; </label>
                            <div> { this.state.underexcLimX1.melmax }</div>
                        </div>
                        <div className = "row">
                            <label> tf2:&emsp; </label>
                            <div> { this.state.underexcLimX1.tf2 }</div>
                        </div>
                        <div className = "row">
                            <label> tm:&emsp; </label>
                            <div> { this.state.underexcLimX1.tm }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewUnderexcLimX1Component
