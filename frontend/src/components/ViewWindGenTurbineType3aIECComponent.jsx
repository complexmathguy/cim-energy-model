import React, { Component } from 'react'
import WindGenTurbineType3aIECService from '../services/WindGenTurbineType3aIECService'

class ViewWindGenTurbineType3aIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windGenTurbineType3aIEC: {}
        }
    }

    componentDidMount(){
        WindGenTurbineType3aIECService.getWindGenTurbineType3aIECById(this.state.id).then( res => {
            this.setState({windGenTurbineType3aIEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindGenTurbineType3aIEC Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> kpc:&emsp; </label>
                            <div> { this.state.windGenTurbineType3aIEC.kpc }</div>
                        </div>
                        <div className = "row">
                            <label> tic:&emsp; </label>
                            <div> { this.state.windGenTurbineType3aIEC.tic }</div>
                        </div>
                        <div className = "row">
                            <label> xs:&emsp; </label>
                            <div> { this.state.windGenTurbineType3aIEC.xs }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindGenTurbineType3aIECComponent
