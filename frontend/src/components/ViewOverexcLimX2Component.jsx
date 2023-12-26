import React, { Component } from 'react'
import OverexcLimX2Service from '../services/OverexcLimX2Service'

class ViewOverexcLimX2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            overexcLimX2: {}
        }
    }

    componentDidMount(){
        OverexcLimX2Service.getOverexcLimX2ById(this.state.id).then( res => {
            this.setState({overexcLimX2: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View OverexcLimX2 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> efd1:&emsp; </label>
                            <div> { this.state.overexcLimX2.efd1 }</div>
                        </div>
                        <div className = "row">
                            <label> efd2:&emsp; </label>
                            <div> { this.state.overexcLimX2.efd2 }</div>
                        </div>
                        <div className = "row">
                            <label> efd3:&emsp; </label>
                            <div> { this.state.overexcLimX2.efd3 }</div>
                        </div>
                        <div className = "row">
                            <label> efddes:&emsp; </label>
                            <div> { this.state.overexcLimX2.efddes }</div>
                        </div>
                        <div className = "row">
                            <label> efdrated:&emsp; </label>
                            <div> { this.state.overexcLimX2.efdrated }</div>
                        </div>
                        <div className = "row">
                            <label> kmx:&emsp; </label>
                            <div> { this.state.overexcLimX2.kmx }</div>
                        </div>
                        <div className = "row">
                            <label> m:&emsp; </label>
                            <div> { this.state.overexcLimX2.m }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.overexcLimX2.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.overexcLimX2.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.overexcLimX2.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> vlow:&emsp; </label>
                            <div> { this.state.overexcLimX2.vlow }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewOverexcLimX2Component
