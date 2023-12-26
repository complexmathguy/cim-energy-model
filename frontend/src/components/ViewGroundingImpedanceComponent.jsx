import React, { Component } from 'react'
import GroundingImpedanceService from '../services/GroundingImpedanceService'

class ViewGroundingImpedanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            groundingImpedance: {}
        }
    }

    componentDidMount(){
        GroundingImpedanceService.getGroundingImpedanceById(this.state.id).then( res => {
            this.setState({groundingImpedance: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GroundingImpedance Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> x:&emsp; </label>
                            <div> { this.state.groundingImpedance.x }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGroundingImpedanceComponent
