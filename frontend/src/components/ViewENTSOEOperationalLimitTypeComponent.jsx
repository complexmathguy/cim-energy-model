import React, { Component } from 'react'
import ENTSOEOperationalLimitTypeService from '../services/ENTSOEOperationalLimitTypeService'

class ViewENTSOEOperationalLimitTypeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            eNTSOEOperationalLimitType: {}
        }
    }

    componentDidMount(){
        ENTSOEOperationalLimitTypeService.getENTSOEOperationalLimitTypeById(this.state.id).then( res => {
            this.setState({eNTSOEOperationalLimitType: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ENTSOEOperationalLimitType Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> limitType:&emsp; </label>
                            <div> { this.state.eNTSOEOperationalLimitType.limitType }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewENTSOEOperationalLimitTypeComponent
