import React, { Component } from 'react'
import SwitchItService from '../services/SwitchItService'

class ViewSwitchItComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            switchIt: {}
        }
    }

    componentDidMount(){
        SwitchItService.getSwitchItById(this.state.id).then( res => {
            this.setState({switchIt: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SwitchIt Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> open:&emsp; </label>
                            <div> { this.state.switchIt.open }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSwitchItComponent
