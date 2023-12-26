import React, { Component } from 'react'
import LoadAreaService from '../services/LoadAreaService';

class UpdateLoadAreaComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateLoadArea = this.updateLoadArea.bind(this);

    }

    componentDidMount(){
        LoadAreaService.getLoadAreaById(this.state.id).then( (res) =>{
            let loadArea = res.data;
            this.setState({
            });
        });
    }

    updateLoadArea = (e) => {
        e.preventDefault();
        let loadArea = {
            loadAreaId: this.state.id,
        };
        console.log('loadArea => ' + JSON.stringify(loadArea));
        console.log('id => ' + JSON.stringify(this.state.id));
        LoadAreaService.updateLoadArea(loadArea).then( res => {
            this.props.history.push('/loadAreas');
        });
    }


    cancel(){
        this.props.history.push('/loadAreas');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update LoadArea</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateLoadArea}>Save</button>
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

export default UpdateLoadAreaComponent
