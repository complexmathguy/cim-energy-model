import React, { Component } from 'react'
import GrossToNetActivePowerCurveService from '../services/GrossToNetActivePowerCurveService'

class ViewGrossToNetActivePowerCurveComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            grossToNetActivePowerCurve: {}
        }
    }

    componentDidMount(){
        GrossToNetActivePowerCurveService.getGrossToNetActivePowerCurveById(this.state.id).then( res => {
            this.setState({grossToNetActivePowerCurve: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GrossToNetActivePowerCurve Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGrossToNetActivePowerCurveComponent
