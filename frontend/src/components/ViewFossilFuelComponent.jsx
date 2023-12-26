import React, { Component } from 'react'
import FossilFuelService from '../services/FossilFuelService'

class ViewFossilFuelComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            fossilFuel: {}
        }
    }

    componentDidMount(){
        FossilFuelService.getFossilFuelById(this.state.id).then( res => {
            this.setState({fossilFuel: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View FossilFuel Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> fossilFuelType:&emsp; </label>
                            <div> { this.state.fossilFuel.fossilFuelType }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewFossilFuelComponent
