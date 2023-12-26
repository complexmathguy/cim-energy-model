import React, { Component } from 'react'
import AnalogLimitSetService from '../services/AnalogLimitSetService'

class ViewAnalogLimitSetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            analogLimitSet: {}
        }
    }

    componentDidMount(){
        AnalogLimitSetService.getAnalogLimitSetById(this.state.id).then( res => {
            this.setState({analogLimitSet: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View AnalogLimitSet Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewAnalogLimitSetComponent
