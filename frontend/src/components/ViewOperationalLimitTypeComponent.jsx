import React, { Component } from 'react'
import OperationalLimitTypeService from '../services/OperationalLimitTypeService'

class ViewOperationalLimitTypeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            operationalLimitType: {}
        }
    }

    componentDidMount(){
        OperationalLimitTypeService.getOperationalLimitTypeById(this.state.id).then( res => {
            this.setState({operationalLimitType: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View OperationalLimitType Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> acceptableDuration:&emsp; </label>
                            <div> { this.state.operationalLimitType.acceptableDuration }</div>
                        </div>
                        <div className = "row">
                            <label> direction:&emsp; </label>
                            <div> { this.state.operationalLimitType.direction }</div>
                        </div>
                        <div className = "row">
                            <label> limitType:&emsp; </label>
                            <div> { this.state.operationalLimitType.limitType }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewOperationalLimitTypeComponent
