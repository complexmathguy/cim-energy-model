import React, { Component } from 'react'
import AccumulatorLimitSetService from '../services/AccumulatorLimitSetService'

class ViewAccumulatorLimitSetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            accumulatorLimitSet: {}
        }
    }

    componentDidMount(){
        AccumulatorLimitSetService.getAccumulatorLimitSetById(this.state.id).then( res => {
            this.setState({accumulatorLimitSet: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View AccumulatorLimitSet Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewAccumulatorLimitSetComponent
