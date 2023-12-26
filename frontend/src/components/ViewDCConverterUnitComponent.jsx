import React, { Component } from 'react'
import DCConverterUnitService from '../services/DCConverterUnitService'

class ViewDCConverterUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            dCConverterUnit: {}
        }
    }

    componentDidMount(){
        DCConverterUnitService.getDCConverterUnitById(this.state.id).then( res => {
            this.setState({dCConverterUnit: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DCConverterUnit Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> operationMode:&emsp; </label>
                            <div> { this.state.dCConverterUnit.operationMode }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDCConverterUnitComponent
