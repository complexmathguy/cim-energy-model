import React, { Component } from 'react'
import UnderexcLim2SimplifiedService from '../services/UnderexcLim2SimplifiedService'

class ViewUnderexcLim2SimplifiedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            underexcLim2Simplified: {}
        }
    }

    componentDidMount(){
        UnderexcLim2SimplifiedService.getUnderexcLim2SimplifiedById(this.state.id).then( res => {
            this.setState({underexcLim2Simplified: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View UnderexcLim2Simplified Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> kui:&emsp; </label>
                            <div> { this.state.underexcLim2Simplified.kui }</div>
                        </div>
                        <div className = "row">
                            <label> p0:&emsp; </label>
                            <div> { this.state.underexcLim2Simplified.p0 }</div>
                        </div>
                        <div className = "row">
                            <label> p1:&emsp; </label>
                            <div> { this.state.underexcLim2Simplified.p1 }</div>
                        </div>
                        <div className = "row">
                            <label> q0:&emsp; </label>
                            <div> { this.state.underexcLim2Simplified.q0 }</div>
                        </div>
                        <div className = "row">
                            <label> q1:&emsp; </label>
                            <div> { this.state.underexcLim2Simplified.q1 }</div>
                        </div>
                        <div className = "row">
                            <label> vuimax:&emsp; </label>
                            <div> { this.state.underexcLim2Simplified.vuimax }</div>
                        </div>
                        <div className = "row">
                            <label> vuimin:&emsp; </label>
                            <div> { this.state.underexcLim2Simplified.vuimin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewUnderexcLim2SimplifiedComponent
