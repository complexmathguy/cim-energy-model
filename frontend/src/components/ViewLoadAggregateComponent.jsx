import React, { Component } from 'react'
import LoadAggregateService from '../services/LoadAggregateService'

class ViewLoadAggregateComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            loadAggregate: {}
        }
    }

    componentDidMount(){
        LoadAggregateService.getLoadAggregateById(this.state.id).then( res => {
            this.setState({loadAggregate: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View LoadAggregate Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewLoadAggregateComponent
