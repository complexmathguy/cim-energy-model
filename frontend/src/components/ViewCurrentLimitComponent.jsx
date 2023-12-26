import React, { Component } from 'react'
import CurrentLimitService from '../services/CurrentLimitService'

class ViewCurrentLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            currentLimit: {}
        }
    }

    componentDidMount(){
        CurrentLimitService.getCurrentLimitById(this.state.id).then( res => {
            this.setState({currentLimit: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View CurrentLimit Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.currentLimit.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewCurrentLimitComponent
