import React, { Component } from 'react'
import OperationalLimitSetService from '../services/OperationalLimitSetService'

class ViewOperationalLimitSetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            operationalLimitSet: {}
        }
    }

    componentDidMount(){
        OperationalLimitSetService.getOperationalLimitSetById(this.state.id).then( res => {
            this.setState({operationalLimitSet: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View OperationalLimitSet Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewOperationalLimitSetComponent
