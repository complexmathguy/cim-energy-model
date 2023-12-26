import React, { Component } from 'react'
import Simple_FloatService from '../services/Simple_FloatService'

class ViewSimple_FloatComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            simple_Float: {}
        }
    }

    componentDidMount(){
        Simple_FloatService.getSimple_FloatById(this.state.id).then( res => {
            this.setState({simple_Float: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Simple_Float Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.simple_Float.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSimple_FloatComponent
