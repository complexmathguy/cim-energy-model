import React, { Component } from 'react'
import GovHydroIEEE0Service from '../services/GovHydroIEEE0Service'

class ViewGovHydroIEEE0Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govHydroIEEE0: {}
        }
    }

    componentDidMount(){
        GovHydroIEEE0Service.getGovHydroIEEE0ById(this.state.id).then( res => {
            this.setState({govHydroIEEE0: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovHydroIEEE0 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> k:&emsp; </label>
                            <div> { this.state.govHydroIEEE0.k }</div>
                        </div>
                        <div className = "row">
                            <label> mwbase:&emsp; </label>
                            <div> { this.state.govHydroIEEE0.mwbase }</div>
                        </div>
                        <div className = "row">
                            <label> pmax:&emsp; </label>
                            <div> { this.state.govHydroIEEE0.pmax }</div>
                        </div>
                        <div className = "row">
                            <label> pmin:&emsp; </label>
                            <div> { this.state.govHydroIEEE0.pmin }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.govHydroIEEE0.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.govHydroIEEE0.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.govHydroIEEE0.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> t4:&emsp; </label>
                            <div> { this.state.govHydroIEEE0.t4 }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovHydroIEEE0Component
