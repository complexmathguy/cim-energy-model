import React, { Component } from 'react'
import DynamicsFunctionBlockService from '../services/DynamicsFunctionBlockService'

class ViewDynamicsFunctionBlockComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            dynamicsFunctionBlock: {}
        }
    }

    componentDidMount(){
        DynamicsFunctionBlockService.getDynamicsFunctionBlockById(this.state.id).then( res => {
            this.setState({dynamicsFunctionBlock: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DynamicsFunctionBlock Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> enabled:&emsp; </label>
                            <div> { this.state.dynamicsFunctionBlock.enabled }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDynamicsFunctionBlockComponent
