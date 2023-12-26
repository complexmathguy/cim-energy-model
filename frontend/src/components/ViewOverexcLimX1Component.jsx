import React, { Component } from 'react'
import OverexcLimX1Service from '../services/OverexcLimX1Service'

class ViewOverexcLimX1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            overexcLimX1: {}
        }
    }

    componentDidMount(){
        OverexcLimX1Service.getOverexcLimX1ById(this.state.id).then( res => {
            this.setState({overexcLimX1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View OverexcLimX1 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> efd1:&emsp; </label>
                            <div> { this.state.overexcLimX1.efd1 }</div>
                        </div>
                        <div className = "row">
                            <label> efd2:&emsp; </label>
                            <div> { this.state.overexcLimX1.efd2 }</div>
                        </div>
                        <div className = "row">
                            <label> efd3:&emsp; </label>
                            <div> { this.state.overexcLimX1.efd3 }</div>
                        </div>
                        <div className = "row">
                            <label> efddes:&emsp; </label>
                            <div> { this.state.overexcLimX1.efddes }</div>
                        </div>
                        <div className = "row">
                            <label> efdrated:&emsp; </label>
                            <div> { this.state.overexcLimX1.efdrated }</div>
                        </div>
                        <div className = "row">
                            <label> kmx:&emsp; </label>
                            <div> { this.state.overexcLimX1.kmx }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.overexcLimX1.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.overexcLimX1.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.overexcLimX1.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> vlow:&emsp; </label>
                            <div> { this.state.overexcLimX1.vlow }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewOverexcLimX1Component
