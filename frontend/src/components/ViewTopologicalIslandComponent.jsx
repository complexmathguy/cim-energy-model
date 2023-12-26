import React, { Component } from 'react'
import TopologicalIslandService from '../services/TopologicalIslandService'

class ViewTopologicalIslandComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            topologicalIsland: {}
        }
    }

    componentDidMount(){
        TopologicalIslandService.getTopologicalIslandById(this.state.id).then( res => {
            this.setState({topologicalIsland: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View TopologicalIsland Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewTopologicalIslandComponent
