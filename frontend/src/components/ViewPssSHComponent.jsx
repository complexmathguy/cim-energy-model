import React, { Component } from 'react'
import PssSHService from '../services/PssSHService'

class ViewPssSHComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pssSH: {}
        }
    }

    componentDidMount(){
        PssSHService.getPssSHById(this.state.id).then( res => {
            this.setState({pssSH: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PssSH Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> k:&emsp; </label>
                            <div> { this.state.pssSH.k }</div>
                        </div>
                        <div className = "row">
                            <label> k0:&emsp; </label>
                            <div> { this.state.pssSH.k0 }</div>
                        </div>
                        <div className = "row">
                            <label> k1:&emsp; </label>
                            <div> { this.state.pssSH.k1 }</div>
                        </div>
                        <div className = "row">
                            <label> k2:&emsp; </label>
                            <div> { this.state.pssSH.k2 }</div>
                        </div>
                        <div className = "row">
                            <label> k3:&emsp; </label>
                            <div> { this.state.pssSH.k3 }</div>
                        </div>
                        <div className = "row">
                            <label> k4:&emsp; </label>
                            <div> { this.state.pssSH.k4 }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.pssSH.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.pssSH.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.pssSH.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> t4:&emsp; </label>
                            <div> { this.state.pssSH.t4 }</div>
                        </div>
                        <div className = "row">
                            <label> td:&emsp; </label>
                            <div> { this.state.pssSH.td }</div>
                        </div>
                        <div className = "row">
                            <label> vsmax:&emsp; </label>
                            <div> { this.state.pssSH.vsmax }</div>
                        </div>
                        <div className = "row">
                            <label> vsmin:&emsp; </label>
                            <div> { this.state.pssSH.vsmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPssSHComponent
