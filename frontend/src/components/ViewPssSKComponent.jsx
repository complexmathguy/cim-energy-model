import React, { Component } from 'react'
import PssSKService from '../services/PssSKService'

class ViewPssSKComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pssSK: {}
        }
    }

    componentDidMount(){
        PssSKService.getPssSKById(this.state.id).then( res => {
            this.setState({pssSK: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PssSK Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> k1:&emsp; </label>
                            <div> { this.state.pssSK.k1 }</div>
                        </div>
                        <div className = "row">
                            <label> k2:&emsp; </label>
                            <div> { this.state.pssSK.k2 }</div>
                        </div>
                        <div className = "row">
                            <label> k3:&emsp; </label>
                            <div> { this.state.pssSK.k3 }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.pssSK.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.pssSK.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.pssSK.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> t4:&emsp; </label>
                            <div> { this.state.pssSK.t4 }</div>
                        </div>
                        <div className = "row">
                            <label> t5:&emsp; </label>
                            <div> { this.state.pssSK.t5 }</div>
                        </div>
                        <div className = "row">
                            <label> t6:&emsp; </label>
                            <div> { this.state.pssSK.t6 }</div>
                        </div>
                        <div className = "row">
                            <label> vsmax:&emsp; </label>
                            <div> { this.state.pssSK.vsmax }</div>
                        </div>
                        <div className = "row">
                            <label> vsmin:&emsp; </label>
                            <div> { this.state.pssSK.vsmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPssSKComponent
