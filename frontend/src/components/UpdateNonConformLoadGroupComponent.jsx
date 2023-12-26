import React, { Component } from 'react'
import NonConformLoadGroupService from '../services/NonConformLoadGroupService';

class UpdateNonConformLoadGroupComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateNonConformLoadGroup = this.updateNonConformLoadGroup.bind(this);

    }

    componentDidMount(){
        NonConformLoadGroupService.getNonConformLoadGroupById(this.state.id).then( (res) =>{
            let nonConformLoadGroup = res.data;
            this.setState({
            });
        });
    }

    updateNonConformLoadGroup = (e) => {
        e.preventDefault();
        let nonConformLoadGroup = {
            nonConformLoadGroupId: this.state.id,
        };
        console.log('nonConformLoadGroup => ' + JSON.stringify(nonConformLoadGroup));
        console.log('id => ' + JSON.stringify(this.state.id));
        NonConformLoadGroupService.updateNonConformLoadGroup(nonConformLoadGroup).then( res => {
            this.props.history.push('/nonConformLoadGroups');
        });
    }


    cancel(){
        this.props.history.push('/nonConformLoadGroups');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update NonConformLoadGroup</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateNonConformLoadGroup}>Save</button>
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

export default UpdateNonConformLoadGroupComponent
