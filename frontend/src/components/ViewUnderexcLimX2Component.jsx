import React, { Component } from 'react'
import UnderexcLimX2Service from '../services/UnderexcLimX2Service'

class ViewUnderexcLimX2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            underexcLimX2: {}
        }
    }

    componentDidMount(){
        UnderexcLimX2Service.getUnderexcLimX2ById(this.state.id).then( res => {
            this.setState({underexcLimX2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View UnderexcLimX2 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> kf2:&emsp; </label>
                            <div> { this.state.underexcLimX2.kf2 }</div>
                        </div>
                        <div className = "row">
                            <label> km:&emsp; </label>
                            <div> { this.state.underexcLimX2.km }</div>
                        </div>
                        <div className = "row">
                            <label> melmax:&emsp; </label>
                            <div> { this.state.underexcLimX2.melmax }</div>
                        </div>
                        <div className = "row">
                            <label> qo:&emsp; </label>
                            <div> { this.state.underexcLimX2.qo }</div>
                        </div>
                        <div className = "row">
                            <label> r:&emsp; </label>
                            <div> { this.state.underexcLimX2.r }</div>
                        </div>
                        <div className = "row">
                            <label> tf2:&emsp; </label>
                            <div> { this.state.underexcLimX2.tf2 }</div>
                        </div>
                        <div className = "row">
                            <label> tm:&emsp; </label>
                            <div> { this.state.underexcLimX2.tm }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewUnderexcLimX2Component
