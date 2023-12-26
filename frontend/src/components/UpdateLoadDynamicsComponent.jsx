import React, { Component } from 'react'
import LoadDynamicsService from '../services/LoadDynamicsService';

class UpdateLoadDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateLoadDynamics = this.updateLoadDynamics.bind(this);

    }

    componentDidMount(){
        LoadDynamicsService.getLoadDynamicsById(this.state.id).then( (res) =>{
            let loadDynamics = res.data;
            this.setState({
            });
        });
    }

    updateLoadDynamics = (e) => {
        e.preventDefault();
        let loadDynamics = {
            loadDynamicsId: this.state.id,
        };
        console.log('loadDynamics => ' + JSON.stringify(loadDynamics));
        console.log('id => ' + JSON.stringify(this.state.id));
        LoadDynamicsService.updateLoadDynamics(loadDynamics).then( res => {
            this.props.history.push('/loadDynamicss');
        });
    }


    cancel(){
        this.props.history.push('/loadDynamicss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update LoadDynamics</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateLoadDynamics}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateLoadDynamicsComponent
