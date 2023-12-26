import React, { Component } from 'react'
import WindGenTurbineType3bIECService from '../services/WindGenTurbineType3bIECService'

class ViewWindGenTurbineType3bIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windGenTurbineType3bIEC: {}
        }
    }

    componentDidMount(){
        WindGenTurbineType3bIECService.getWindGenTurbineType3bIECById(this.state.id).then( res => {
            this.setState({windGenTurbineType3bIEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindGenTurbineType3bIEC Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> fducw:&emsp; </label>
                            <div> { this.state.windGenTurbineType3bIEC.fducw }</div>
                        </div>
                        <div className = "row">
                            <label> mwtcwp:&emsp; </label>
                            <div> { this.state.windGenTurbineType3bIEC.mwtcwp }</div>
                        </div>
                        <div className = "row">
                            <label> tg:&emsp; </label>
                            <div> { this.state.windGenTurbineType3bIEC.tg }</div>
                        </div>
                        <div className = "row">
                            <label> two:&emsp; </label>
                            <div> { this.state.windGenTurbineType3bIEC.two }</div>
                        </div>
                        <div className = "row">
                            <label> xs:&emsp; </label>
                            <div> { this.state.windGenTurbineType3bIEC.xs }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindGenTurbineType3bIECComponent
