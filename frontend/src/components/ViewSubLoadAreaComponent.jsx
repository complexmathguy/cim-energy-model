import React, { Component } from 'react'
import SubLoadAreaService from '../services/SubLoadAreaService'

class ViewSubLoadAreaComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            subLoadArea: {}
        }
    }

    componentDidMount(){
        SubLoadAreaService.getSubLoadAreaById(this.state.id).then( res => {
            this.setState({subLoadArea: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SubLoadArea Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSubLoadAreaComponent
