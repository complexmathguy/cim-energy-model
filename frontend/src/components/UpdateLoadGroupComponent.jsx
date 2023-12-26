import React, { Component } from 'react'
import LoadGroupService from '../services/LoadGroupService';

class UpdateLoadGroupComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateLoadGroup = this.updateLoadGroup.bind(this);

    }

    componentDidMount(){
        LoadGroupService.getLoadGroupById(this.state.id).then( (res) =>{
            let loadGroup = res.data;
            this.setState({
            });
        });
    }

    updateLoadGroup = (e) => {
        e.preventDefault();
        let loadGroup = {
            loadGroupId: this.state.id,
        };
        console.log('loadGroup => ' + JSON.stringify(loadGroup));
        console.log('id => ' + JSON.stringify(this.state.id));
        LoadGroupService.updateLoadGroup(loadGroup).then( res => {
            this.props.history.push('/loadGroups');
        });
    }


    cancel(){
        this.props.history.push('/loadGroups');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update LoadGroup</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateLoadGroup}>Save</button>
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

export default UpdateLoadGroupComponent
