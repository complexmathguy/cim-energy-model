import React, { Component } from 'react'
import TurbLCFB1Service from '../services/TurbLCFB1Service'

class ViewTurbLCFB1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            turbLCFB1: {}
        }
    }

    componentDidMount(){
        TurbLCFB1Service.getTurbLCFB1ById(this.state.id).then( res => {
            this.setState({turbLCFB1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View TurbLCFB1 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> db:&emsp; </label>
                            <div> { this.state.turbLCFB1.db }</div>
                        </div>
                        <div className = "row">
                            <label> emax:&emsp; </label>
                            <div> { this.state.turbLCFB1.emax }</div>
                        </div>
                        <div className = "row">
                            <label> fb:&emsp; </label>
                            <div> { this.state.turbLCFB1.fb }</div>
                        </div>
                        <div className = "row">
                            <label> fbf:&emsp; </label>
                            <div> { this.state.turbLCFB1.fbf }</div>
                        </div>
                        <div className = "row">
                            <label> irmax:&emsp; </label>
                            <div> { this.state.turbLCFB1.irmax }</div>
                        </div>
                        <div className = "row">
                            <label> ki:&emsp; </label>
                            <div> { this.state.turbLCFB1.ki }</div>
                        </div>
                        <div className = "row">
                            <label> kp:&emsp; </label>
                            <div> { this.state.turbLCFB1.kp }</div>
                        </div>
                        <div className = "row">
                            <label> mwbase:&emsp; </label>
                            <div> { this.state.turbLCFB1.mwbase }</div>
                        </div>
                        <div className = "row">
                            <label> pbf:&emsp; </label>
                            <div> { this.state.turbLCFB1.pbf }</div>
                        </div>
                        <div className = "row">
                            <label> pmwset:&emsp; </label>
                            <div> { this.state.turbLCFB1.pmwset }</div>
                        </div>
                        <div className = "row">
                            <label> speedReferenceGovernor:&emsp; </label>
                            <div> { this.state.turbLCFB1.speedReferenceGovernor }</div>
                        </div>
                        <div className = "row">
                            <label> tpelec:&emsp; </label>
                            <div> { this.state.turbLCFB1.tpelec }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewTurbLCFB1Component
