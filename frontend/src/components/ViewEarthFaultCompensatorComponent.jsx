import React, { Component } from 'react'
import EarthFaultCompensatorService from '../services/EarthFaultCompensatorService'

class ViewEarthFaultCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            earthFaultCompensator: {}
        }
    }

    componentDidMount(){
        EarthFaultCompensatorService.getEarthFaultCompensatorById(this.state.id).then( res => {
            this.setState({earthFaultCompensator: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View EarthFaultCompensator Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> r:&emsp; </label>
                            <div> { this.state.earthFaultCompensator.r }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewEarthFaultCompensatorComponent
