import React, { Component } from 'react'
import SubLoadAreaService from '../services/SubLoadAreaService';

class UpdateSubLoadAreaComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateSubLoadArea = this.updateSubLoadArea.bind(this);

    }

    componentDidMount(){
        SubLoadAreaService.getSubLoadAreaById(this.state.id).then( (res) =>{
            let subLoadArea = res.data;
            this.setState({
            });
        });
    }

    updateSubLoadArea = (e) => {
        e.preventDefault();
        let subLoadArea = {
            subLoadAreaId: this.state.id,
        };
        console.log('subLoadArea => ' + JSON.stringify(subLoadArea));
        console.log('id => ' + JSON.stringify(this.state.id));
        SubLoadAreaService.updateSubLoadArea(subLoadArea).then( res => {
            this.props.history.push('/subLoadAreas');
        });
    }


    cancel(){
        this.props.history.push('/subLoadAreas');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update SubLoadArea</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSubLoadArea}>Save</button>
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

export default UpdateSubLoadAreaComponent
