import React, { Component } from 'react'
import ConformLoadGroupService from '../services/ConformLoadGroupService';

class UpdateConformLoadGroupComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateConformLoadGroup = this.updateConformLoadGroup.bind(this);

    }

    componentDidMount(){
        ConformLoadGroupService.getConformLoadGroupById(this.state.id).then( (res) =>{
            let conformLoadGroup = res.data;
            this.setState({
            });
        });
    }

    updateConformLoadGroup = (e) => {
        e.preventDefault();
        let conformLoadGroup = {
            conformLoadGroupId: this.state.id,
        };
        console.log('conformLoadGroup => ' + JSON.stringify(conformLoadGroup));
        console.log('id => ' + JSON.stringify(this.state.id));
        ConformLoadGroupService.updateConformLoadGroup(conformLoadGroup).then( res => {
            this.props.history.push('/conformLoadGroups');
        });
    }


    cancel(){
        this.props.history.push('/conformLoadGroups');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ConformLoadGroup</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateConformLoadGroup}>Save</button>
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

export default UpdateConformLoadGroupComponent
