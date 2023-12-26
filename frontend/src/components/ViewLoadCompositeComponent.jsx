import React, { Component } from 'react'
import LoadCompositeService from '../services/LoadCompositeService'

class ViewLoadCompositeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            loadComposite: {}
        }
    }

    componentDidMount(){
        LoadCompositeService.getLoadCompositeById(this.state.id).then( res => {
            this.setState({loadComposite: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View LoadComposite Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> epfd:&emsp; </label>
                            <div> { this.state.loadComposite.epfd }</div>
                        </div>
                        <div className = "row">
                            <label> epfs:&emsp; </label>
                            <div> { this.state.loadComposite.epfs }</div>
                        </div>
                        <div className = "row">
                            <label> epvd:&emsp; </label>
                            <div> { this.state.loadComposite.epvd }</div>
                        </div>
                        <div className = "row">
                            <label> epvs:&emsp; </label>
                            <div> { this.state.loadComposite.epvs }</div>
                        </div>
                        <div className = "row">
                            <label> eqfd:&emsp; </label>
                            <div> { this.state.loadComposite.eqfd }</div>
                        </div>
                        <div className = "row">
                            <label> eqfs:&emsp; </label>
                            <div> { this.state.loadComposite.eqfs }</div>
                        </div>
                        <div className = "row">
                            <label> eqvd:&emsp; </label>
                            <div> { this.state.loadComposite.eqvd }</div>
                        </div>
                        <div className = "row">
                            <label> eqvs:&emsp; </label>
                            <div> { this.state.loadComposite.eqvs }</div>
                        </div>
                        <div className = "row">
                            <label> h:&emsp; </label>
                            <div> { this.state.loadComposite.h }</div>
                        </div>
                        <div className = "row">
                            <label> lfrac:&emsp; </label>
                            <div> { this.state.loadComposite.lfrac }</div>
                        </div>
                        <div className = "row">
                            <label> pfrac:&emsp; </label>
                            <div> { this.state.loadComposite.pfrac }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewLoadCompositeComponent
