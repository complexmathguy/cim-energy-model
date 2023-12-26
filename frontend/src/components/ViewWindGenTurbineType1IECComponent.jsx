import React, { Component } from 'react'
import WindGenTurbineType1IECService from '../services/WindGenTurbineType1IECService'

class ViewWindGenTurbineType1IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            windGenTurbineType1IEC: {}
        }
    }

    componentDidMount(){
        WindGenTurbineType1IECService.getWindGenTurbineType1IECById(this.state.id).then( res => {
            this.setState({windGenTurbineType1IEC: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View WindGenTurbineType1IEC Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewWindGenTurbineType1IECComponent
