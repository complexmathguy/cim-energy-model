import React, { Component } from 'react'
import LoadBreakSwitchService from '../services/LoadBreakSwitchService'

class ViewLoadBreakSwitchComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            loadBreakSwitch: {}
        }
    }

    componentDidMount(){
        LoadBreakSwitchService.getLoadBreakSwitchById(this.state.id).then( res => {
            this.setState({loadBreakSwitch: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View LoadBreakSwitch Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewLoadBreakSwitchComponent
